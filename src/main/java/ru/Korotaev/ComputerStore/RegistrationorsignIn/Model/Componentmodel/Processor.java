package ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel;

import java.util.Objects;

/***
 * This class is model for processor objects which created in AdminProcessorServlet,
 * AdminComputer, ProcessorServlet, ProcessorDao classes and AdminProcessor.jsp
 * and Processor.jsp files.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class Processor {
    /**
     * Field id at processor
     */
    private int id;
    /**
     * Field name at processor
     */
    private String name;
    /**
     * Field name at processor
     */
    private int price;
    /**
     * Field count at processor
     */
    private int counts;

    /**
     * Constructor for create new main plate object
     */
    public Processor() {
    }

    /**
     * @param id - Constructor for create new object by id
     */
    public Processor(int id) {
        this.id = id;
    }

    /**
     * @return - id at processor object
     */
    public int getId() {
        return id;
    }

    /**
     * @param id - by processor object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return - name at processor object
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - by processor object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return - price at processor
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price - by processor object
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return - count at processor object
     */
    public int getCounts() {
        return counts;
    }

    /**
     * @param counts - by processor object
     */
    public void setCounts(int counts) {
        this.counts = counts;
    }

    /**
     * @param o - this other processor object
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
        Processor processor = (Processor) o;
        return id == processor.id && price == processor.price && counts == processor.counts && name.equals(processor.name);
    }

    /**
     * @return - hashCode at processor object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id , name , price , counts);
    }

    /**
     * @return - String about information with fields processor class
     */
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
