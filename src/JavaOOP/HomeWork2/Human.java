package JavaOOP.HomeWork2;

public abstract class Human implements Communication, Comparable<Human> {

    private String name;
    private Double money;
    private int loveIndex;

    public Human(String name, Double money, int loveIndex) {
        this.name = name;
        this.money = money;
        this.loveIndex = loveIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public int compareTo(Human o) {
        return  this.loveIndex - o.loveIndex;
    }

    @Override
    public void makingPurchase(double sells, Human o){

        if (o instanceof Seller){
            this.money -= sells;
        }else{
            this.money += sells;
        }
    }

    @Override
    public String toString() {
        return money.toString();
    }
}
