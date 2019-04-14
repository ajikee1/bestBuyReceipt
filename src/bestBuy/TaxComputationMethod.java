package bestBuy;

//AUTHOR: AJITH V KEERIKKATTIL

import java.util.Calendar;

public abstract class TaxComputationMethod {

    public abstract double computeTax(PurchasedItems items, Calendar date);

    public abstract boolean taxHoliday(Calendar date);
}
