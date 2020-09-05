package by.java.oop_2.bean.person.person_children;

import by.java.oop_2.bean.payment.Payment;
import by.java.oop_2.bean.person.Person;

import java.util.Objects;

public final class User extends Person {

    /* Класс описывает пользователя интернет магазина. */

    private static long idUnique = 0;

    private final long id;
    private String email;
    private Payment payment;

    public User() {
        super();
        id = idUnique++;
        email = "";
        payment = new Payment();
    }

    public User(String surname, String name, String patronymic, int age, Sex sex, String email)
    {
        super(surname, name, patronymic, age, sex);
        id = idUnique++;
        this.email = email;
        payment = new Payment();
    }

    public User(String surname, String name, String patronymic, int age, Sex sex) {
        super(surname, name, patronymic, age, sex);
        id = idUnique++;
        payment = new Payment();
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "User id: " + id
                + " | " + getSurname()
                + " " + getName()
                + " " + getPatronymic()
                + " | " + "Age: " + getAge()
                + " | " + "Sex: " + getSex().toString()
                + " | " + "email: " + ((email != null) ? email : "") + "\n"
                + payment.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email) &&
                Objects.equals(payment, user.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, email, payment);
    }
}