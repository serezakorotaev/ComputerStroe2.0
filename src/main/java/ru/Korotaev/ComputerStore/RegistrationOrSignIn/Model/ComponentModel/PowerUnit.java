package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel;

import java.util.Objects;
/***
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 * This class is model for power units objects which created in AdminPowerUnitServlet,
 * AdminComputer, PowerUnitServlet, PowerUnitDao classes and AdminPowerUnit.jsp
 * and PowerUnit.jsp files.
 */
public class PowerUnit {
    /**
     * Field id at power unit
     */
    private int id;
    /**
     * Field name at power unit
     */
    private String name;
    /**
     * Field price at power unit
     */
    private int price;
    /**
     * Field count at power unit
     */
    private int counts;


    /**
     * Constructor for create new power unit object
     */
    public PowerUnit(){}

    /**
     *
     * @param id
     * Constructor for create new object by id
     */
    public PowerUnit(int id) {
        this.id = id;
    }

    /**
     *
     * @return id at power unit object
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id by power unit object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name at power unit object
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name by power unit object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return price at power unit
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price by power unit object
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
     * @param o this other power unit object
     * @return true or false by comparison elements
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerUnit powerUnit = (PowerUnit) o;
        return id == powerUnit.id && price == powerUnit.price && counts == powerUnit.counts && name.equals(powerUnit.name);
    }

    /**
     *
     * @return power unit at power unit object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, counts);
    }

    /**
     *
     * @return String about information with fields power unit class
     */
    @Override
    public String toString() {
        return "PowerUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", counts=" + counts +
                '}';
    }
}
