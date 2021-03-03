package ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel;

import java.util.Objects;

/***
 * This class is model for main plate objects which created in AdminMainPlateServlet,
 * AdminComputer, MainPLateServlet, MainPlateDao classes and AdminManePlate.jsp
 * and ManePlate.jsp files.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class RamMemory {
    /**
     * Field id at RAM Memory
     */
    private int id;
    /**
     * Field name at RAM Memory
     */
    private String name;
    /**
     * Field price at RAM Memory
     */
    private int price;
    /**
     * Field count at RAM Memory
     */
    private int counts;

    /**
     * Constructor for create new RAM Memory object
     */
    public RamMemory() {
    }

    /**
     * @param id - Constructor for create new RAM Memory object by id
     */
    public RamMemory(int id) {
        this.id = id;
    }

    /**
     * @return - id at RAM Memory object
     */
    public int getId() {
        return id;
    }

    /**
     * @param id - by RAM Memory object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return - name at RAM Memory object
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - by RAM Memory object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return - price at RAM Memory
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price - by RAM Memory object
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return - count at RAM Memory object
     */
    public int getCounts() {
        return counts;
    }

    /**
     * @param counts - by RAM Memory object
     */
    public void setCounts(int counts) {
        this.counts = counts;
    }

    /**
     * @param o - this other RAM Memory object
     * @return - true or false by comparison elements
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RamMemory ramMemory = (RamMemory) o;
        return id == ramMemory.id && price == ramMemory.price && counts == ramMemory.counts && name.equals(ramMemory.name);
    }

    /**
     * @return - hashCode at RAM Memory object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id , name , price , counts);
    }

    /**
     * @return - String about information with fields main plate class
     */
    @Override
    public String toString() {
        return "RamMemory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", counts=" + counts +
                '}';
    }
}
