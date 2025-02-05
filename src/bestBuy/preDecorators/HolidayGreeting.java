package bestBuy.preDecorators;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.general.PurchasedItems;
import bestBuy.interfaces.SecondaryHeading;

public class HolidayGreeting implements SecondaryHeading {

    public boolean applies(PurchasedItems items) {
        return true; // SecondaryHeading decorators always applied
    }

    //Secondary heading content
    public String getLines() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("             **  Happy Holidays from Best Buy  **      ");
        sb.append("\n");
        return sb.toString();
    }
}
