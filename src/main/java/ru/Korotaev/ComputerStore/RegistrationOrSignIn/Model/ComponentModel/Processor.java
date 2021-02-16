package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel;

import java.util.Objects;

public class Processor {
    private int id;
    private String name;
    private int price;
    private int counts;


    private int number;
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Processor(){}

    public Processor(int id) {
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
        Processor processor = (Processor) o;
        return id == processor.id && price == processor.price && counts == processor.counts && name.equals(processor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, counts);
    }

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", counts=" + counts +
                '}';
    }
}
