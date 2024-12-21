package lldQuestions.vendingMachineDesign;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private Map<Product,Integer> productInventory;

    public Inventory(){
        productInventory=new ConcurrentHashMap<>();
    }

    void addProduct(Product product,Integer quantity){
        productInventory.put(product,quantity);
    }

    void removeProduct(Product product){
        productInventory.remove(product);
    }

    void updateQuantity(Product product,int quantity){
        productInventory.put(product,quantity);
    }

    int getQuantity(Product product){
        return productInventory.getOrDefault(product, 0);
    }

    boolean isAvailable(Product product){
        return productInventory.containsKey(product) && productInventory.get(product)>0;
    }
}
