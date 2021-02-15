package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel;

import java.util.Objects;

public class ManePlate {
    private int id;
    private String name;
    private int price;
    private int counts;

    public ManePlate(){}

    public ManePlate(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManePlate manePlate = (ManePlate) o;
        return id == manePlate.id && price == manePlate.price && counts == manePlate.counts && name.equals(manePlate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, counts);
    }

    @Override
    public String toString() {
        return "ManePlate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", counts=" + counts +
                '}';
    }
}
