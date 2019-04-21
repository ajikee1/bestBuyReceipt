package bestBuy.taxComputation;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.general.PurchasedItems;

import java.util.Calendar;

public abstract class TaxComputationMethod {

    public abstract double computeTax(PurchasedItems items, Calendar date);

    public abstract boolean taxHoliday(Calendar date);
}
