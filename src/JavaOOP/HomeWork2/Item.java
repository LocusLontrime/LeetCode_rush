package JavaOOP.HomeWork2;

public class Item {

    private String nameOfItem;
    private Double cost;
    private Category category;

    public Item(String nameOfItem, Double cost, Category category) {
        this.nameOfItem = nameOfItem;
        this.cost = cost;
        this.category = category;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public Double getCost() {
        return cost;
    }

    public Category getCategory() {
        return category;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return nameOfItem;
    }
}
