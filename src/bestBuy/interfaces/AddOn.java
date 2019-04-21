package bestBuy.interfaces;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.general.PurchasedItems;

public interface AddOn {

    boolean applies(PurchasedItems items);

    String getLines();
}
