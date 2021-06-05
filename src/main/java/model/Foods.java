package model;

public class Foods {
    private boolean isPerishable;
    private String description;
    private float price;

    public Foods(boolean isPerishable, String description, float price) {
        this.isPerishable = isPerishable;
        this.description = description;
        this.price = price;
    }

    public boolean getPerishable() {
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

    @Override
    public String toString() {
        return "Foods{" +
                "isPerishable=" + isPerishable +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

