package bestBuy;

public class Rebate1406 implements Rebate {

    StoreItem storeItem;
    String rebateItem = "1406";

    //returns true if the list of purchased items contain an item with the item Number of 1406
    public boolean applies(PurchasedItems purchaseditems) {

        if(purchaseditems.containsItem("rebateItem") == true)
        {
            return true;
        }

        return false;
    }

    public String getLines()
    {
         String itemCode = null;
         String itemDescription = null;
         double itemPrice = 0.00;

         if(storeItem.getItemCode().equalsIgnoreCase(rebateItem))
         {
             itemCode = storeItem.getItemCode();
             itemDescription = storeItem.getItemDescription();
             itemPrice = storeItem.getItemPrice();
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
