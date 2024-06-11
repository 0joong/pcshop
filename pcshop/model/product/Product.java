package pcshop.model.product;

public interface Product {
    int PRODUCTCODE_OF_CPU = 1000;
    int PRODUCTCODE_OF_MEMORY = 2000;
    int PRODUCTCODE_OF_PC = 9000;
    String getName();
    int getPrice();
    int getProductCode();
}
