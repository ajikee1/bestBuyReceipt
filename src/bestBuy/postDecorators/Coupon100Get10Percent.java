package bestBuy.postDecorators;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.general.PurchasedItems;
import bestBuy.interfaces.Coupon;

public class Coupon100Get10Percent implements Coupon {

    //return true if the purchase total is greater than or equal to 100
    public boolean applies(PurchasedItems purchaseditems) {

        return purchaseditems.getTotalCost() >= 100.00;
    }

    //Coupon content
    public String getLines() {
        return "BEST BUY COUPON: " + "10% off next purchase \nGood until 12/31/2019";
    }
}
