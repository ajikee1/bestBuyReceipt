package bestBuy.general;

//AUTHOR: AJITH V KEERIKKATTIL

import bestBuy.interfaces.AddOn;
import bestBuy.interfaces.Receipt;

public abstract class Decorator implements Receipt {
    private Receipt trailer;
    private AddOn addon;

    public Decorator(Receipt r, AddOn a) {
        trailer = r;
        addon = a;
    }

    protected void callTrailer() {
        trailer.prtReceipt();
    }

    public abstract void prtReceipt();

}
