package by.java.oop_2;

import by.java.oop_2.bean.person.Person;
import by.java.oop_2.bean.product.Product;
import by.java.oop_2.bean.person.person_children.User;
import by.java.oop_2.logic.UserLogic;

public class PaymentMain {

    public static void main(String[] args) {

        Product product1 = new Product("Apple iPhone X 64Gb Space Gray (Серый космос)", "Cмартфон", 699);
        Product product2 = new Product("Samsung UE43RU7120UXRU", "Телевизор", 499);
        Product product3 = new Product("Программирование на Java", "Книга", 35);
        Product product4 = new Product("Magnetic Bike TC545", "Велотренажер", 299);
        Product product5 = new Product("Nvidia GeForse RTX 3080Ti", "Видеокарта", 1500);
        Product product6 = new Product("Garrett GT1756VK", "Турбина", 525);
        Product product7 = new Product("Shell Helix Ultra 5W-30 A3/B4 4l", "Моторное масло", 42);
        Product product8 = new Product("Castrol EDGE 0W-30 A3/B4 4l", "Моторное масло", 50);
        Product product9 = new Product("LG PC09SQ", "Сплит-система", 750);

	    User user = new User("Нестеренко", "Антон", "Алексеевич", 27, Person.Sex.MAN);
        UserLogic userLogic = new UserLogic(user);
        System.out.println(user);

        System.out.println();
        userLogic.addProductToPayment(product3);
        userLogic.displayUserInfo();

        System.out.println();
        userLogic.addProductToPayment(product1, 2);
        userLogic.displayUserInfo();

        System.out.println();
        userLogic.addProductToPayment(product7);
        userLogic.displayUserInfo();

        System.out.println();
        userLogic.removeProductFromPayment(user.getPayment().getProductsInPayment().get(1));
        userLogic.displayUserInfo();

        System.out.println();
        userLogic.changeQuantityOfProductInPayment(user.getPayment().getProductsInPayment().get(1), 10);
        userLogic.displayUserInfo();

        System.out.println();
        userLogic.clearPayment();
        userLogic.displayUserInfo();
    }
}