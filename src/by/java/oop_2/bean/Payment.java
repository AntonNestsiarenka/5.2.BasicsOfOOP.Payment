package by.java.oop_2.bean;

import java.util.ArrayList;
import java.util.Objects;

public final class Payment implements IPayment {

    /* Класс описывает корзину товаров. */

    private double commonPriceOfProducts;
    private ArrayList<ProductInPayment> productsInPayment;

    public Payment()
    {
        commonPriceOfProducts = 0;
        productsInPayment = new ArrayList<>();
    }

    public double getCommonPriceOfProducts() {
        recalculateCommonPriceInPayment();
        return commonPriceOfProducts;
    }

    public void setCommonPriceOfProducts(double commonPriceOfProducts) {
        this.commonPriceOfProducts = commonPriceOfProducts;
    }

    public ArrayList<ProductInPayment> getProductsInPayment() {
        return productsInPayment;
    }

    public void setProductsInPayment(ArrayList<ProductInPayment> productsInPayment) {
        this.productsInPayment = productsInPayment;
    }

    public class ProductInPayment {

        /* Внутренний класс описывает товар в корзине. */

        private Product product;
        private int count;

        public ProductInPayment(Product product) {
            this.product = product;
            count = 1;
        }

        public ProductInPayment(Product product, int count)
        {
            this.product = product;
            this.count = (count > 0) ? count : 1;
        }

        public void incrementCount()
        {
            ++count;
        }

        public void decrementCount()
        {
            --count;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return product.toString() + " | " + "NumberOfProducts: " + count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductInPayment that = (ProductInPayment) o;
            return count == that.count &&
                    Objects.equals(product, that.product);
        }

        @Override
        public int hashCode() {
            return Objects.hash(product, count);
        }
    }

    @Override
    public void addToPayment(Product product) {
        // Добавляет товар в корзину.
        Payment.ProductInPayment productInPayment = findProductById(product);
        if (productInPayment != null)
        {
            productInPayment.incrementCount();
        }
        else {
            productsInPayment.add(new ProductInPayment(product));
        }
        recalculateCommonPriceInPayment();
    }

    @Override
    public void addToPayment(Product product, int count) throws InvalidAmountException {
        /* Добавляет товар в корзину в определенном количестве. Метод выбрасывает исключение InvalidAmountException
           если заданное количество товаров меньше 1. */
        if (count < 1)
        {
            throw new InvalidAmountException("The number of products must be from 1 or more.");
        }
        Payment.ProductInPayment productInPayment = findProductById(product);
        if (productInPayment != null)
        {
            productInPayment.setCount(productInPayment.getCount() + count);
        }
        else
        {
            productsInPayment.add(new ProductInPayment(product, count));
        }
        recalculateCommonPriceInPayment();
    }

    @Override
    public void removeFromPayment(Payment.ProductInPayment product) {
        // Удаляет товар из корзины.
        productsInPayment.remove(product);
        recalculateCommonPriceInPayment();
    }

    @Override
    public void clearPayment() {
        // Очищает корзину.
        productsInPayment.clear();
        recalculateCommonPriceInPayment();
    }

    @Override
    public void changeCountOfProduct(Payment.ProductInPayment product, int newCount) throws InvalidAmountException {
        /* Изменяет количество заданного товара в корзине. Метод выбрасывает исключение InvalidAmountException
           если заданное количество товара меньше 1. */
        if (newCount < 1)
        {
            throw new InvalidAmountException("The number of products must be from 1 or more.");
        }
        product.setCount(newCount);
        recalculateCommonPriceInPayment();
    }

    @Override
    public void incrementCountOfProduct(Payment.ProductInPayment product) {
        // Добавляет к количеству заданного товара 1.
        product.incrementCount();
        recalculateCommonPriceInPayment();
    }

    @Override
    public void decrementCountOfProduct(Payment.ProductInPayment product) {
        // Отнимает от заданного количества товара 1.
        if (product.getCount() > 1)
        {
            product.decrementCount();
            recalculateCommonPriceInPayment();
        }
    }

    @Override
    public double getCommonPriceOfAllProductsInPayment() {
        // Получить общую стоимость товаров в корзине.
        return getCommonPriceOfProducts();
    }

    public ProductInPayment findProductById(Product product)
    {
        // Поиск товара в корзине. Возвращает объект ProductInPayment если такой объект есть либо null если нет.
        for (ProductInPayment productInPayment : productsInPayment)
        {
            if (productInPayment.getProduct().getId() == product.getId())
                return productInPayment;
        }
        return null;
    }

    private void recalculateCommonPriceInPayment()
    {
        // Пересчет стоимости корзины товаров.
        double tempCommonPriceOfProducts = 0;
        for (ProductInPayment productInPayment : productsInPayment)
        {
            tempCommonPriceOfProducts += (productInPayment.product.getPrice() * productInPayment.count);
        }
        commonPriceOfProducts = tempCommonPriceOfProducts;
    }

    @Override
    public String toString() {
        StringBuilder newStr = new StringBuilder();
        for (ProductInPayment productInPayment : productsInPayment)
        {
            newStr.append(productInPayment.toString() + '\n');
        }
        newStr.append("Total price of products: " + getCommonPriceOfProducts());
        return newStr.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.commonPriceOfProducts, commonPriceOfProducts) == 0 &&
                Objects.equals(productsInPayment, payment.productsInPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commonPriceOfProducts, productsInPayment);
    }
}