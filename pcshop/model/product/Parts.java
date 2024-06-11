package pcshop.model.product;

public class Parts implements Product {
    public int price;
    public String name;
    public int productCode;

    public Parts() {
    }//기본 생성자

    public Parts(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public void setPartsInformation() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
