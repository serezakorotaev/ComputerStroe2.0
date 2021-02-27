package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel;

import java.util.Objects;
/***
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 * This class is model for main plate objects which created in AdminMainPlateServlet,
 * AdminComputer, MainPLateServlet, MainPlateDao classes and AdminManePlate.jsp
 * and ManePlate.jsp files.
 */
public class MainPlate {
    /**
     * Field id at main plate
     */
    private int id;
    /**
     * Field name at main plate
     */
    private String name;
    /**
     * Field price at main plate
     */
    private int price;
    /**
     * Field count at main plate
     */
    private int counts;

    /**
     * Constructor for create new main plate object
     */
    public MainPlate(){}

    /**
     *
     * @param id
     * Constructor for create new object by id
     */
    public MainPlate(int id) {
        this.id = id;
    }

    /**
     *
     * @return id at main plate object
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id by main plate object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name at main plate object
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name by main plate object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return price at main plate
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price by main plate object
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return count at main plate object
     */
    public int getCounts() {
        return counts;
    }

    /**
     *
     * @param counts by main plate object
     */
    public void setCounts(int counts) {
        this.counts = counts;
    }


    /**
     *
     * @param o this other main plate object
     * @return true or false by comparison elements
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainPlate manePlate = (MainPlate) o;
        return id == manePlate.id && price == manePlate.price && counts == manePlate.counts && name.equals(manePlate.name);
    }

    /**
     *
     * @return hashCode at main plate object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, counts);
    }

    /**
     *
     * @return String about information with fields main plate class
     */
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
