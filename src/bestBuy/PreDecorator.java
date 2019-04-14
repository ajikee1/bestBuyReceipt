package bestBuy;

public class PreDecorator extends Decorator {

    private AddOn a;

    public PreDecorator(Receipt r, AddOn a) {
        super(r, a);
    }

    public void prtReceipt() {
        System.out.println(a.getLines());
        callTrailer();
    }
}
