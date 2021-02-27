package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel;

import java.util.Objects;
/***
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 * This class is model for video cards objects which created in AdminVideoCardServlet,
 * AdminComputer, VideoCardServlet, VideoCardDao classes and AdminVideoCard.jsp
 * and VideoCard.jsp files.
 */
public class VideoCard {
    /**
     *Field id at video card object
     */
    private int id;
    /**
     * Field name at video card object
     */
    private String name;
    /**
     *  Field price at video card
     */
    private int price;
    /**
     * Field count at video card
     */
    private int counts;

    /**
     *Constructor for create new video card object
     */
    public VideoCard(){}

    /**
     *
     * @param id
     * Constructor for create new object by id
     */
    public VideoCard(int id) {
        this.id = id;
    }

    /**
     *
     * @return id at video card object
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id by video card object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name at video card object
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name by video card object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return price at video card
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price by video card object
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return count at video card object
     */
    public int getCounts() {
        return counts;
    }

    /**
     *
     * @param counts by video card object
     */
    public void setCounts(int counts) {
        this.counts = counts;
    }

    /**
     *
     * @param o this other video card object
     * @return true or false by comparison elements
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoCard videoCard = (VideoCard) o;
        return id == videoCard.id && price == videoCard.price && counts == videoCard.counts && name.equals(videoCard.name);
    }

    /**
     *
     * @return hashCode at video card object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, counts);
    }

    /**
     *
     * @return String about information with fields video cards class
     */
    @Override
    public String toString() {
        return "VideoCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", counts=" + counts +
                '}';
    }
}
