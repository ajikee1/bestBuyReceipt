package bestBuy.preDecorators;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.general.Decorator;
import bestBuy.interfaces.AddOn;
import bestBuy.interfaces.Receipt;

public class PreDecorator extends Decorator {

    private AddOn a;

    public PreDecorator(Receipt r, AddOn a) {
        super(r, a);
        this.a = a;
    }

    public void prtReceipt() {
        System.out.println(a.getLines());
        callTrailer();
    }
}
