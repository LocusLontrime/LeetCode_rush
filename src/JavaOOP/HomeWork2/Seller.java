package JavaOOP.HomeWork2;

import java.util.ArrayList;
import java.util.List;

public class Seller extends Human{

    private List<Item> item = new ArrayList<>();

    public Seller(String name, Double money, int loveIndex) {
        super(name, money, loveIndex);
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public void addProduct(Item product){
        item.add(product);
    }

    @Override
    public String toString() {
        return item.toString();
    }

}
