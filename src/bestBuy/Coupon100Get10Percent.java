package bestBuy;

public class Coupon100Get10Percent implements Coupon{

    public boolean applies(PurchasedItems items) {
        return items.containsItem("1406");
    }

    public String getLines()
    {
        return "BEST BUY COUPON  10% off next purchase Good until 12/31/2018";
    }
}
