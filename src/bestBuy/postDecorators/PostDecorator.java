package bestBuy.postDecorators;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.general.Decorator;
import bestBuy.interfaces.AddOn;
import bestBuy.interfaces.Receipt;

public class PostDecorator extends Decorator {

    private AddOn a;

    public PostDecorator(Receipt r, AddOn a) {
        super(r, a);
        this.a = a;
    }

    public void prtReceipt() {
        callTrailer();
        System.out.println(a.getLines());
    }
}
