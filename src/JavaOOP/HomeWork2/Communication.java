package JavaOOP.HomeWork2;

import java.util.ArrayList;
import java.util.List;

public interface Communication {

    default Double costInItem(Item item) {
        return item.getCost();
    }

    default void isItemInStorage(Seller seller, List<Item> wishListOfConsumer) { // Проверка есть ли товар в магазине
        for (Item item : wishListOfConsumer) {
            System.out.println("Do you have a " + item.getNameOfItem());
            if (!seller.getItem().contains(item)) {
                System.out.println("Sorry we have not " + item.getNameOfItem());
            }else {
                System.out.println("Of course!");
            }
        }
    }

    default double totalCoast(ArrayList<Item> wishList) { // Вся стоимость виш листа
        double fullCoastWishList = 0;

        for (Item item : wishList) {
            fullCoastWishList += item.getCost();
        }
        return fullCoastWishList;
    }

    default void areYouPoor(Consumer consumer) { // Бедняк и в Африке бедняк

        if (totalCoast(consumer.getWishList()) > consumer.getMoney()) {
            System.out.println("You are poor, but if your love index more than seller, i think you can all item in wishlist");
        }

    }

    default void getSpecialSellsFromSeller(int loveIndex, Consumer consumer) { // Получение скидки от продавца за симпатию

        if (loveIndex > 0) {
            System.out.println("Oooo, my friend, i will give you a discount");
            double sells = getSells(consumer.getWishList());
            if (consumer.getMoney() > sells) {
                System.out.println("Discounted products will stand: " + sells);
            }
        } else {
            System.out.println("If you don't have enough money get out of here");
        }

    }

    default double getSells(ArrayList<Item> wishList) { // Уменьшение размера стоимости всего виш листа на 25 процентов
        double totalCoast = totalCoast(wishList);
        return totalCoast * 0.75;

    }

    void makingPurchase(double sells, Human o);
}
