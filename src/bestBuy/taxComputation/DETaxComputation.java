package bestBuy.taxComputation;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.general.PurchasedItems;

import java.util.Calendar;

//state with no tax
public class DETaxComputation extends TaxComputationMethod {

    @Override
    // throw an exception since DE has no tax
    public double computeTax(PurchasedItems purchaseditems, Calendar purchaseDate) throws ArithmeticException{

       // throw new ArithmeticException("DE does not charge sales tax");
        return 0.00;
    }

    //always returns false as there is no tax in this state
    public boolean taxHoliday(Calendar purchaseDate) {
        return false;
    }

}