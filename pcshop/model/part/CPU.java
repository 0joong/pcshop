package pcshop.model.part;

import pcshop.model.product.Parts;

public class CPU extends Parts {
    private String name;
    private int core;
    private double clock;

    public CPU(int productCode, int price, String name, int core, double clock) {
        this.productCode = productCode;
        this.price = price;
        this.name = name;
        this.core = core;
        this.clock = clock;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "[제품번호 : " + productCode + ", " + name + ", " +
                 core + "코어, " + clock + "Ghz" + ", " + price + "원]";
    }
}