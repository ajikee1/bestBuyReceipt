package bestBuy;

public class StoreItem {

    private String itemCode;
    private String itemDescription;
    private double itemPrice;

    public StoreItem( String code, String description, double price)
    {
        this.itemCode = code;
        this.itemDescription = description;
        this.itemPrice = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String toString()
    {
        String price = Double.toString(getItemPrice());
        return getItemCode() + "\t" + getItemDescription() + "\t" + price;
    }


}
