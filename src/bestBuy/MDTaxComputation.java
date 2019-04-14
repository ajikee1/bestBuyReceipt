package bestBuy;

import java.util.Calendar;

public class MDTaxComputation extends TaxComputationMethod {

    @Override
    public double computeTax(PurchasedItems purchaseditems, Calendar purchaseDate) {

        double mdTax = .06;

        //calling the local taxHoliday() method to see if the date is a tax holiday
        boolean isTaxFreeHoliday = taxHoliday(purchaseDate);

        if(isTaxFreeHoliday == true)
        {
            for (StoreItem item: purchaseditems.items)
            {

            }
        }
    }


    //returns TRUE if the receipt date is on the tax free day
     public boolean taxHoliday(Calendar purchaseDate)
    {
        int taxFreeMonth = Calendar.AUGUST; //MD tax free month
        int taxFreeDay = 14; //MD tax free day

        if (purchaseDate.get(Calendar.MONTH) == taxFreeMonth && purchaseDate.get(Calendar.DAY_OF_MONTH) == taxFreeDay)
        {
            return true;
        }
        return false;
    }

}
