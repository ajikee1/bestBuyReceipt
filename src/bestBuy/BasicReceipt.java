package bestBuy;

import java.util.Calendar;

public class BasicReceipt implements Receipt{

    private StoreHeader store_header; // street address, state code, phone number, store number
    private TaxComputationMethod tc;
    private Calendar date; // may also be a String type
    private PurchasedItems purchaseditems;

    public BasicReceipt(PurchasedItems purchaseditems, Calendar date) {
        this.purchaseditems = purchaseditems;
        this.date = date;
    }

    public void setStoreHeader(StoreHeader h) {
        store_header = h;
    }

    public void setTaxComputationMethod(TaxComputationMethod tc) {
        this.tc = tc;
    }

    //Add the tax to the total to return the final total
    private double totalwithTax(double costPreTax, double tax)
    {
        return costPreTax + tax;
    }

    //print receipt method that prints the basic receipt
    public void prtReceipt() {

        System.out.println("-------------------------------------------------------------------------");

        //Print the BestBuy store address details
        System.out.println("BEST BUY " + "Store # " + store_header.getStore_num());
        System.out.println(store_header.getStreet_addr() + ", " + store_header.getState_code() + ", " + store_header.getZip_code() + ", " +  store_header.getPhone_num());

        //Print the date & time of receipt creation
        System.out.println(date.getTime());
        System.out.println(" ");

        System.out.println("-------------------------------Your Items--------------------------------");
        System.out.println(" ");

        //Print the list of items that are being purchased
        for (StoreItem item: purchaseditems.purchaseditems)
        {
            System.out.println(item.getItemCode() + "\t" + item.getItemDescription() + "\t" + item.getItemPrice());
        }

        //Get the total amount before taxes
        System.out.println(" ");
        System.out.println("Total before taxes: $" + purchaseditems.getTotalCost());

        //Calculate and display state specific sales tax
        System.out.println(" ");
        System.out.println(store_header.getState_code() + " Sales tax $: " + tc.computeTax(purchaseditems, date));

        //Final total
        System.out.println(" ");
        System.out.println("Total with taxes: $"  + totalwithTax(purchaseditems.getTotalCost(),tc.computeTax(purchaseditems, date)));

        System.out.println("-------------------------------------------------------------------------");

    }

    }
