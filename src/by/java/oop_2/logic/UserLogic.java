package by.java.oop_2.logic;

import by.java.oop_2.bean.payment.InvalidAmountException;
import by.java.oop_2.bean.payment.Payment;
import by.java.oop_2.bean.product.Product;
import by.java.oop_2.bean.person.person_children.User;
import by.java.oop_2.view.Viewer;

import java.util.Objects;

public final class UserLogic {

    private User user;

    public UserLogic()
    {
        user = new User();
    }

    public UserLogic(User user)
    {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addProductToPayment(Product product)
    {
        user.getPayment().addToPayment(product);
        Viewer.printMessage("Product " + product.getName() + " was added to payment.");
    }

    public void addProductToPayment(Product product, int count)
    {
        String message = "Product " + product.getName() + " was added to payment.";
        try {
            user.getPayment().addToPayment(product, count);
        } catch (InvalidAmountException e) {
            Viewer.printMessage(e.getMessage());
            message = "Product " + product.getName() + " wasn`t added to payment.";
        }
        Viewer.printMessage(message);
    }

    public void removeProductFromPayment(Payment.ProductInPayment productInPayment)
    {
        user.getPayment().removeFromPayment(productInPayment);
        Viewer.printMessage("Product " + productInPayment.getProduct().getName() + " was removed from payment.");
    }

    public void clearPayment()
    {
        user.getPayment().clearPayment();
        Viewer.printMessage("Payment was cleared.");
    }

    public void changeQuantityOfProductInPayment(Payment.ProductInPayment productInPayment, int newNumber)
    {
        String message = "Quantity of product " + productInPayment.getProduct().getName() + " has been changed.";
        try {
            user.getPayment().changeCountOfProduct(productInPayment, newNumber);
        } catch (InvalidAmountException e) {
            Viewer.printMessage(e.getMessage());
            message = "Quantity of product " + productInPayment.getProduct().getName() + " hasn`t been changed.";
        }
        Viewer.printMessage(message);
    }

    public void incrementQuantityOfProductInPayment(Payment.ProductInPayment productInPayment)
    {
        user.getPayment().incrementCountOfProduct(productInPayment);
    }

    public void decrementQuantityOfProductInPayment(Payment.ProductInPayment productInPayment)
    {
        user.getPayment().decrementCountOfProduct((productInPayment));
    }

    public void displayUserPayment()
    {
        Viewer.printMessage(user.getPayment().toString());
    }

    public void displayUserInfo()
    {
        Viewer.printMessage(user.toString());
    }

    @Override
    public String toString() {
        return "UserLogic{" +
                "user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLogic userLogic = (UserLogic) o;
        return Objects.equals(user, userLogic.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}