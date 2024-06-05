package pcshop.model.part;

import pcshop.model.product.Parts;

public class GPU extends Parts {

    int core;
    int clock;

    public GPU(int price, String name) {
        super(price, name);
    }
}
