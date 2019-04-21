package bestBuy.taxComputation;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.general.PurchasedItems;

import java.util.Calendar;

//state with no tax
public class DETaxComputation extends TaxComputationMethod {

    @Override
    public double computeTax(PurchasedItems purchaseditems, Calendar purchaseDate) {

        double deTax = .00;
        double tax = 0.00;

        //calling the local taxHoliday() method to see if the date is a tax holiday
        boolean isTaxFreeHoliday = taxHoliday(purchaseDate);

        if (isTaxFreeHoliday == false) {
            tax = purchaseditems.getTotalCost() * deTax;
        }
        return tax;
    }

    //always returns false as there is no tax in this state
    public boolean taxHoliday(Calendar purchaseDate) {
        return false;
    }

}