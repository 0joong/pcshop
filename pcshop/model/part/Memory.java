package pcshop.model.part;

import pcshop.model.product.Parts;

public class Memory extends Parts {
    private int capacity;
    private String generation;
    public Memory(int productCode, int price, String name, String generation, int capacity) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.generation = generation;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
//        return "Memory{" +
//                "capacity=" + capacity +
//                ", generation='" + generation + '\'' +
//                ", price=" + price +
//                ", name='" + name + '\'' +
//                ", productCode=" + productCode +
//                '}';

        return "[제품번호 : " + productCode + ", " + name + ", " +
                generation + ", " + capacity + "GB" + ", " + price + "원]";
    }
}
