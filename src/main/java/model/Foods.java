package model;

public class Foods {
    private String category;
    private boolean isPerishable;
    private String description;
    private float price;

    public Foods(String category, boolean isPerishable, String description, float price) {
        this.category = category;
        this.isPerishable = isPerishable;
        this.description = description;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}