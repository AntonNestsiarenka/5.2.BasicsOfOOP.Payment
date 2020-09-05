package by.java.oop_2.bean.payment;

import by.java.oop_2.bean.product.Product;

public interface IPayment {

    /* Интерфейс для работы с корзиной товаров. */

    void addToPayment(Product product);

    void addToPayment(Product product, int count) throws InvalidAmountException;

    void removeFromPayment(Payment.ProductInPayment product);

    void clearPayment();

    void changeCountOfProduct(Payment.ProductInPayment product, int newCount) throws InvalidAmountException;

    void incrementCountOfProduct(Payment.ProductInPayment product);

    void decrementCountOfProduct(Payment.ProductInPayment product);

    double getCommonPriceOfAllProductsInPayment();

}