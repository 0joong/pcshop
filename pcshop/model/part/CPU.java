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
        return "CPU{" +
                "clock=" + clock +
                ", name='" + name + '\'' +
                ", core=" + core +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", productCode=" + productCode +
                '}';
    }
}
    /* 추후 추가
    private boolean inner_Graphic;
    private String generation;
    private String manufacturer;
    private String socket;
    private String CMOS;
    private String memory_type;

        private class Cash{
        int L1;
        int L2;
        int L3;
    }
    private class Graphic{
        int graphic_Core;
        int frequency;
        int base;
        String graphic;
    }
    */