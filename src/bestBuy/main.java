package bestBuy;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        //Creates a Date object and prompt the user for the date
        System.out.print("\nEnter date in yyy-mm-dd format: ");
        Scanner sc = new Scanner(System.in);
        String dtPrompt = sc.nextLine();
        Calendar calendar = getDate(dtPrompt);
       // System.out.println(calendar.get(Calendar.MONTH) + 1);

        //Display all items in the inventory
        ArrayList<StoreItem> Inventory = getInventory();
        System.out.println("Items in our inventory: ");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("ITEM CODE \t" + "ITEM DESCRIPTION \t" + "ITEM PRICE");
        for (StoreItem inventoryItem: Inventory)
        {
            System.out.println(inventoryItem.getItemCode() + "\t" + inventoryItem.getItemDescription() + "\t" + inventoryItem.getItemPrice());
        }
        System.out.println("-------------------------------------------------------------------------");

        //Ask the user to enter the item Code to purchase Cart
        System.out.print("Enter the Item Code of the item to purchase: ");
        String selection = sc.nextLine();
        PurchasedItems Purchase = purchaseItem(Inventory, selection);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("");

        //Create the receipts
        ReceiptFactory factory = new ReceiptFactory(calendar);
        Receipt receipt = factory.getReceipt(Purchase, calendar);
        receipt.prtReceipt();


    }

    public static Calendar getDate(String dtPrompt)
    {
        //Creates a Date object and prompt the user for the date
        Calendar calendar = Calendar.getInstance();
        Date date;

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        fmt.setLenient(false);

        try{
            date = fmt.parse(dtPrompt);
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE));
            calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND));
        }
        catch (ParseException e)
        {}

        return calendar;
    }


    public static ArrayList<StoreItem> getInventory()
    {
        //Read items from inventory file and display to user
        ArrayList<StoreItem> inventory = new ArrayList<StoreItem>();

        try {
            Scanner sc2 = new Scanner(new File("/Users/ajithkeerikkattil/Desktop/intelliJcode/bestBuyReceipt/bbInventory.txt"));

            while (sc2.hasNext())
            {
                String inventoryLine = sc2.nextLine();
                String[] split = inventoryLine.split(",");
                String itemCode = split[0];
                String itemDescription = split[1];
                Double itemPrice = Double.parseDouble(split[2]);

                inventory.add(new StoreItem(itemCode, itemDescription,itemPrice ));
            }
            sc2.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }

        return inventory;
    }

    //method that add the user selection to PurchasedItems
    public static PurchasedItems purchaseItem(ArrayList<StoreItem> inventory, String selection)
    {
        ArrayList<StoreItem> purchaseItem = new ArrayList<StoreItem>();
        PurchasedItems purchasedItems = new PurchasedItems();

        for(StoreItem item :inventory)
        {
            if (selection.equalsIgnoreCase(item.getItemCode()))
            {
                purchasedItems.addItem(new StoreItem(item.getItemCode(), item.getItemDescription(), item.getItemPrice()));
                System.out.println("........Adding "+ item.getItemDescription() + " to the cart.");
            }
        }
        return purchasedItems;
    }


}
