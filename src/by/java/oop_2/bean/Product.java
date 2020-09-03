package by.java.oop_2.bean;

import java.util.Objects;

public final class Product {

    /* Класс описывает товар интернет магазина. */

    private static long idUnique = 0;

    private final long id;
    private String name;
    private String description;
    private double price; // usd

    public Product()
    {
        id = idUnique++;
        name = "";
        description = "";
        price = 0;
    }

    public Product(String name, String description, double price) {
        id = idUnique++;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product id: " + id
                + " | " + getName()
                + " | " + getDescription()
                + " | " + getPrice() + " USD";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }
}