package bestBuy;

import java.util.ArrayList;

public class PurchasedItems {

    public ArrayList <StoreItem> items;

    //constructor
    public PurchasedItems()
    {

        items = new ArrayList();
    }

    public void addItem( StoreItem item)
    {
        items.add(item);
    }

    //get the total cost of items in the purchase array
    public double getTotalCost()

    {
        double totalCost = 0;

        for(StoreItem item: items)
        {
            totalCost += item.getItemPrice();
        }
        return totalCost;
    }

    public boolean containsItem(String itemCode)
    {

        return true;
    }



}
