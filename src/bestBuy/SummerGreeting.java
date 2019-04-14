package bestBuy;

//AUTHOR: AJITH V KEERIKKATTIL

public class SummerGreeting implements SecondaryHeading {

    public boolean applies(PurchasedItems items) {
        return true; // SecondaryHeading decorators always applied
    }

    //Secondary heading content
    public String getLines() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("             **  Summer Sales are Hot at Best Buy  **      ");
        sb.append("\n");
        return sb.toString();
    }
}