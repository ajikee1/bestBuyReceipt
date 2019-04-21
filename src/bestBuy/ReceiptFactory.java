package bestBuy;

//AUTHOR: AJITH V KEERIKKATTIL

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class ReceiptFactory {

    StoreHeader store_header;
    private String storeID;
    private String storeAddress;
    private String storePhone;
    private String stateCode;
    private String zip_code;
    private TaxComputationMethod[] taxComputationsObjs;  // tax computation objects (for each state)
    private TaxComputationMethod taxComputationObject;
    private AddOn[] addOns; // secondary heading, rebate and coupon add-ons (hardcoded here)


    public ReceiptFactory(Calendar date) { // constructor

        // Populates array of TaxComputationMethod objects and array of AddOn objects (as if downloaded from the BestBuy web site).
        addOns = new AddOn[3];
        if (date.get(Calendar.MONTH) == Calendar.NOVEMBER || date.get(Calendar.MONTH) == Calendar.DECEMBER) {
            addOns[0] = new HolidayGreeting();
        } else if (date.get(Calendar.MONTH) == Calendar.JUNE || date.get(Calendar.MONTH) == Calendar.JULY || date.get(Calendar.MONTH) == Calendar.AUGUST) {
            addOns[0] = new SummerGreeting();
        } else {
            addOns[0] = new SecondaryHeading() {
                @Override
                public boolean applies(PurchasedItems items) {
                    return true;
                }

                @Override
                public String getLines() {
                    return " ";
                }
            };
        }

        addOns[1] = new Coupon100Get10Percent();
        addOns[2] = new Rebate1406();

        taxComputationsObjs = new TaxComputationMethod[5];
        taxComputationsObjs[0] = new MDTaxComputation();
        taxComputationsObjs[1] = new DETaxComputation();
        taxComputationsObjs[2] = new ILTaxComputation();


        // Reads config file to create and save StoreHeader object (store_num, street_addr, etc.) to be used on all receipts.
        try {
            Scanner sc = new Scanner(new File("/Users/ajithkeerikkattil/Desktop/intelliJcode/bestBuyReceipt/config.dat"));
            this.storeID = sc.nextLine();
            this.storeAddress = sc.nextLine();
            this.storePhone = sc.nextLine();
            this.stateCode = sc.nextLine();
            this.zip_code = sc.nextLine();

            //Initialize the storeHeader
            store_header = new StoreHeader(storeAddress, zip_code, stateCode, storePhone, storeID);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        //Based on the state code (e.g., “MD”) creates and stores appropriate StateComputation object to be used on all receipts.
        if (stateCode.equalsIgnoreCase("MD")) {
            taxComputationObject = taxComputationsObjs[0];
        }
        else if (stateCode.equalsIgnoreCase("DE"))
        {
            taxComputationObject = taxComputationsObjs[1];
        }
        else if (stateCode.equalsIgnoreCase("IL"))
        {
            taxComputationObject = taxComputationsObjs[2];
        }
    }

    public Receipt getReceipt(PurchasedItems purchasedItems, Calendar date) {

        // 1. Sets the current date of the BasicReceipt.
        Receipt receipt = new BasicReceipt(purchasedItems, date);

        // 2. Sets StoreHeader object of the BasicReceipt (by call to SetStoreHeader of BasicReceipt)
        ((BasicReceipt) receipt).setStoreHeader(store_header);

        //3. Sets the TaxComputationMethod object of the BasicReceipt (by call to the setTaxComputationMethod of BasicReceipt).
        ((BasicReceipt) receipt).setTaxComputationMethod(taxComputationObject);


        // 4. Traverses over all AddOn objects, calling the applies method of each. If an AddOn object applies, then determines if the AddOn is of type SecondaryHeader, Rebate, or Coupon.
        //If of type SecondaryHeader, then creates a PreDecorator for the AddOn. If of type Rebate or Coupon, then creates a PostDecorator.
        for (AddOn on : addOns) {
            if (on.applies(purchasedItems) == true && on instanceof SecondaryHeading) {
                // 5. Links in the decorator object based on the Decorator design pattern.
                receipt = new PreDecorator(receipt, on);
            }

            if (on.applies(purchasedItems) == true && on instanceof Coupon) {
                receipt = new PostDecorator(receipt, on);
            }

            if (on.applies(purchasedItems) == false && on instanceof Rebate) {
                receipt = new PostDecorator(receipt, on);
            }
        }

        // 6. Returns decorated BasicReceipt object as type Receipt.
        return receipt;
    }

}
