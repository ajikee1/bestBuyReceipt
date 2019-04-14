package bestBuy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class ReceiptFactory {

    private String storeID;
    private String storeAddress;
    private String storePhone;
    private String stateCode;
    private String zip_code;

    StoreHeader store_header;
    private TaxComputationMethod[] taxComputationsObjs;  // tax computation objs (for each state)
    private AddOn[] addOns; // secondary heading, rebate and coupon add-ons (hardcoded here)


    public ReceiptFactory() { // constructor

        // 1. Populates array of TaxComputationMethod objects and array of AddOn objects (as if downloaded from the BestBuy web site).
        addOns = new AddOn[3];
        addOns[0] = new HolidayGreeting();
        addOns[1] = new Coupon100Get10Percent();
        addOns[2] = new Rebate1406();

        taxComputationsObjs = new TaxComputationMethod[5];
        taxComputationsObjs[0] = new MDTaxComputation();


        // 2. Reads config file to create and save StoreHeader object (store_num, street_addr, etc.) to be used on all receipts.
        try {
            Scanner sc = new Scanner(new File("/Users/ajithkeerikkattil/Desktop/intelliJcode/bestBuyReceipt/config.dat"));
            this.storeID =sc.nextLine();
            this.storeAddress = sc.nextLine();
            this.storePhone = sc.nextLine();
            this.stateCode = sc.nextLine();
            this.zip_code = sc.nextLine();

            //Initialize the storeHeader
            store_header = new StoreHeader(storeAddress, zip_code, stateCode, storePhone,storeID);

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }

        // 3. Based on the state code (e.g., “MD”) creates and stores appropriate StateComputation object to be used on all receipts.
    }

    public Receipt getReceipt(PurchasedItems purchasedItems, Calendar date) {

        // 1. Sets the current date of the BasicReceipt.
        Receipt receipt = new BasicReceipt(purchasedItems, date);

        // 2. Sets StoreHeader object of the BasicReceipt (by call to SetStoreHeader of BasicReceipt)
        ((BasicReceipt) receipt).setStoreHeader(store_header);


        if(stateCode.equalsIgnoreCase("MD")) {
            //3. Sets the TaxComputationMethod object of the BasicReceipt (by call to the setTaxComputationMethod of BasicReceipt).
            ((BasicReceipt) receipt).setTaxComputationMethod(taxComputationsObjs[0]);
        }

        // 4. Traverses over all AddOn objects, calling the applies method of each. If an AddOn object applies, then determines if the AddOn is of type SecondaryHeader, Rebate, or Coupon.
        //If of type SecondaryHeader, then creates a PreDecorator for the AddOn. If of type Rebate or Coupon, then creates a PostDecorator.
        for (AddOn on: addOns)
        {
            if(on.applies(purchasedItems) == true && on instanceof SecondaryHeading)
            {
                // 5. Links in the decorator object based on the Decorator design pattern.
                receipt = new PreDecorator(receipt, on);

            }
            else if ((on.applies(purchasedItems) == true && on instanceof Coupon) || (on.applies(purchasedItems) ==true && on instanceof Rebate))
            {
                // 5. Links in the decorator object based on the Decorator design pattern.
                receipt = new PostDecorator(receipt, on);
            }
        }

        // 6. Returns decorated BasicReceipt object as type Receipt.
        return receipt;
    }

    }
