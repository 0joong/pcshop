package pcshop.model.part;

import pcshop.model.product.Parts;

public class Memory extends Parts {
    private int capacity;
    private String generation;
//    private int bandSwitch;
    public Memory(int productCode, int price, String name, String generation, int capacity) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.generation = generation;
        this.capacity = capacity;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "capacity=" + capacity +
                ", generation='" + generation + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", productCode=" + productCode +
                '}';
    }
}
