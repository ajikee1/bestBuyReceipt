package bestBuy;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PurchasedItems {

    public ArrayList <StoreItem> purchaseditems;

    //constructor
    public PurchasedItems()
    {

        purchaseditems = new ArrayList();
    }

    //add a storeItem to the purchaseItem array
    public void addItem( StoreItem item)
    {
        purchaseditems.add(item);
    }

    //get the total cost of items in the purchase array
    public double getTotalCost()

    {
        double totalCost = 0;

        for(StoreItem item: purchaseditems)
        {
            totalCost += item.getItemPrice();
        }
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        String costFormat = numberFormat.format(totalCost);
        return Double.parseDouble(costFormat);
    }

    //returns true if the purchaseItem array contains an item with the specified itemCode
    public boolean containsItem(String itemCode)
    {
        for (StoreItem item: purchaseditems)
        {
            if (item.getItemCode().equalsIgnoreCase(itemCode))
                return true;
        }
        return false;
    }



}
