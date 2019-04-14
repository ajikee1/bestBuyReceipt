package bestBuy;

import java.util.ArrayList;

public class Rebate1406 implements Rebate {

    ArrayList<StoreItem> storeItem = new ArrayList<StoreItem>();
    String rebateItem = "5543";

    //returns true if the list of purchased items contain an item with the item Number of 1406
    public boolean applies(PurchasedItems purchaseditems) {
        return purchaseditems.containsItem("rebateItem");
    }

    public String getLines()
    {
         String itemCode = null;
         String itemDescription = null;
         double itemPrice = 0.00;

         for(StoreItem item: storeItem)
         {
             if (item.getItemCode().equalsIgnoreCase(rebateItem)) {
                 itemCode = item.getItemCode();
                 itemDescription = item.getItemDescription();
                 itemPrice = item.getItemPrice();
             }
         }

        StringBuilder sb = new StringBuilder();
        sb.append("$10 rebate for " + itemCode + " " + itemDescription + " " + itemPrice);
        sb.append("\n ");
        sb.append("Mail ORIGINAL receipt and Proof of Purchase from package to:\n");
        sb.append("BEST BUY / SAMSUNG REBATES \n");
        sb.append("1000 Industry Way Owings Mills \n");
        sb.append(" MD 21117 \n");

        return sb.toString();
    }
}
