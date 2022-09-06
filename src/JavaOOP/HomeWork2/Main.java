package JavaOOP.HomeWork2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Item itemMilk = new Item("Milk", 73.2, Category.Food);
        Item itemBread = new Item("Bread", 52.45, Category.Food);
        Item itemPasta = new Item("Pasta", 63.4, Category.Food);
        Item itemMeet = new Item("Meet", 170.2, Category.Food);
        Item itemShampoo = new Item("Shampoo", 270.2, Category.Hygiene);
        Item itemCream = new Item("Cream", 83.2, Category.Hygiene);
        Item itemToothpaste = new Item("Toothpaste", 246.2, Category.Hygiene);
        Item itemCola = new Item("Cola", 55.2, Category.Water);
        Item itemSprite = new Item("Sprite", 53.2, Category.Water);

        Consumer consumer = new Consumer("Mark", 320.33, 15, new ArrayList<>(Arrays.asList(itemMilk, itemBread, itemMeet, itemCola)));
        Seller seller = new Seller("Luba", 5000.00, 11);

        seller.addProduct(itemMilk);
        seller.addProduct(itemBread);
        seller.addProduct(itemPasta);
        seller.addProduct(itemMeet);
        seller.addProduct(itemShampoo);
        seller.addProduct(itemCream);
        seller.addProduct(itemToothpaste);
        seller.addProduct(itemCola);
        seller.addProduct(itemSprite);

        System.out.println("Consumer go to the shop... laylyalay");

        consumer.isItemInStorage(seller, consumer.getWishList());
        System.out.println("----------");

        System.out.println("How much do all these products cost?");
        double coastWishList = consumer.totalCoast(consumer.getWishList());
        double coastWishListWithSell = consumer.getSells(consumer.getWishList());
        System.out.println(coastWishList);

        seller.areYouPoor(consumer);

        int loveIndex = consumer.compareTo(seller);

        seller.getSpecialSellsFromSeller(loveIndex, consumer);

        consumer.makingPurchase(coastWishListWithSell, seller);
        seller.makingPurchase(coastWishListWithSell, consumer);

        System.out.println("Thanks for the purchase come again");

        String lefMoney = String.format("%.2f", consumer.getMoney());
        System.out.println("Oh, there's only so much left " + lefMoney  + " rub");

    }
}
