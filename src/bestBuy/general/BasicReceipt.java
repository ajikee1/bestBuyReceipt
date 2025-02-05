package bestBuy.general;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.taxComputation.TaxComputationMethod;
import bestBuy.interfaces.Receipt;

import java.util.Calendar;

public class BasicReceipt implements Receipt {

    private StoreHeader store_header; // street address, state code, phone number, store number
    private TaxComputationMethod tc;
    private Calendar date; // may also be a String type
    private PurchasedItems purItems;

    public BasicReceipt(PurchasedItems purchaseditems, Calendar date) {
        this.purItems = purchaseditems;
        this.date = date;
    }

    public void setStoreHeader(StoreHeader h) {
        store_header = h;
    }

    public void setTaxComputationMethod(TaxComputationMethod tc) {
        this.tc = tc;
    }

    //Add the tax to the total to return the final total
    private double totalwithTax(double costPreTax, double tax) {
        return costPreTax + tax;
    }

    //print receipt method that prints the basic receipt
    public void prtReceipt() {

        System.out.println("-------------------------------------------------------------------------");

        //Print the BestBuy store address details
        System.out.println("BEST BUY " + "Store # " + store_header.getStore_num());
        System.out.println(store_header.getStreet_addr() + ", " + store_header.getState_code() + ", " + store_header.getZip_code() + ", " + store_header.getPhone_num());

        //Print the date & time of receipt creation
        System.out.println(date.getTime());
        System.out.println(" ");

        System.out.println("-------------------------------Your Items--------------------------------");
        System.out.println(" ");

        //Print the list of items that are being purchased
        for (StoreItem item : purItems.getPurchaseditems()) {
            System.out.println(item.getItemCode() + "\t" + item.getItemDescription() + "\t" + item.getItemPrice());
        }


        //Calculate and display state specific sales tax
        System.out.println(" ");
        if (store_header.getState_code().equalsIgnoreCase("DE"))
            {
                //catch the exception thrown by the DETaxComputation
                try {
                    tc.computeTax(purItems, date);
                    System.out.println("Total: $" + totalwithTax(purItems.getTotalCost(), tc.computeTax(purItems, date)));
                }
                catch (ArithmeticException e)
                {
                }
            }
        else
            {
                //Get the total amount before taxes
                System.out.println(" ");
                System.out.println("Total before taxes: $" + purItems.getTotalCost());

                System.out.println(store_header.getState_code() + " Sales tax $: " + tc.computeTax(purItems, date));

                //Final total
                System.out.println(" ");
                System.out.println("Total with taxes: $" + totalwithTax(purItems.getTotalCost(), tc.computeTax(purItems, date)));
            }

        System.out.println("-------------------------------------------------------------------------");

    }

}
