package bestBuy;

//AUTHOR: AJITH V KEERIKKATTIL

import java.util.Calendar;

public class MDTaxComputation extends TaxComputationMethod {

    @Override
    public double computeTax(PurchasedItems purchaseditems, Calendar purchaseDate) {

        double mdTax = .06;
        double tax = 0.00;

        //calling the local taxHoliday() method to see if the date is a tax holiday
        boolean isTaxFreeHoliday = taxHoliday(purchaseDate);

        if (isTaxFreeHoliday == true) {
            tax = 0.00;
        } else {
            tax = purchaseditems.getTotalCost() * mdTax;
        }
        return tax;
    }

    //returns TRUE if the receipt date is on the tax free day
    public boolean taxHoliday(Calendar purchaseDate) {
        int taxFreeMonth = Calendar.AUGUST; //MD tax free month
        int taxFreeDay = 14; //MD tax free day

        return purchaseDate.get(Calendar.MONTH) == taxFreeMonth && purchaseDate.get(Calendar.DAY_OF_MONTH) == taxFreeDay;
    }

}
