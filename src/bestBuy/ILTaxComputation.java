package bestBuy;

//AUTHOR: AJITH V KEERIKKATTIL

import java.util.Calendar;

//state with sales tax but no tax free day
public class ILTaxComputation extends TaxComputationMethod {

    @Override
    public double computeTax(PurchasedItems purchaseditems, Calendar purchaseDate) {

        double ilTax = .12;
        double tax = 0.00;

        //calling the local taxHoliday() method to see if the date is a tax holiday
        boolean isTaxFreeHoliday = taxHoliday(purchaseDate);

        if (isTaxFreeHoliday == false) {
            tax = purchaseditems.getTotalCost() * ilTax;
        }
        return tax;
    }

    //always returns false as there is no tax free day for this state
    public boolean taxHoliday(Calendar purchaseDate) {
        return false;
    }

}