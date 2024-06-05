package pcshop.model;

import pcshop.model.product.Product;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> itemList = new ArrayList<>();

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    public ArrayList<CartItem> getItemList() {
        return itemList;
    }

    public int getNumItems() {
        return itemList.size();
    }

    public String getItemInfo(int index) {
        return itemList.get(index).toString();
    }

    public void addItem(Product product) {

        CartItem item = getCartItem(product);
        if (item == null) {
            itemList.add(new CartItem(product));
        } else {
            item.addQuantity(1);
        }
    }
    public void addItem(int productCode, PartStorage partStorage){
        addItem(partStorage.getPartById(productCode));
    }


    private CartItem getCartItem(Product product) {
        for (CartItem item : itemList) {
            if (item.getProduct() == product) return item;
        }
        return null;
    }
    public void resetCart() {
        itemList.clear();
    }
    public boolean isValidItem(int productCode) {
        for (CartItem item : itemList)
            if (item.productCode == productCode) return true;
        return false;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}