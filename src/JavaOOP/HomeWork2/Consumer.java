package JavaOOP.HomeWork2;

import java.util.ArrayList;

public class Consumer extends Human {

    private ArrayList<Item> wishList = new ArrayList<>();

    public ArrayList<Item> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<Item> wishList) {
        this.wishList = wishList;
    }

    public Consumer(String name, Double money, int loveIndex, ArrayList<Item> wishList) {
        super(name, money, loveIndex);
        this.wishList = wishList;
    }

    public void necessaryPurchases(Item product){
        wishList.add(product);
    }

    @Override
    public String toString( ) {

        return wishList.toString();
    }


}
