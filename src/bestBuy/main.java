package bestBuy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        //Creates a Date object and prompt the user for the date
        Calendar calendar = Calendar.getInstance();    Date date = null;

        System.out.println("\nEnter date in yyy-mm-dd format: ");

        Scanner sc = new Scanner(System.in);
        String dtPrompt = sc.nextLine();
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
        {

        }


        //Creates a PurchasedItems object (selections made by user)


    }

}
