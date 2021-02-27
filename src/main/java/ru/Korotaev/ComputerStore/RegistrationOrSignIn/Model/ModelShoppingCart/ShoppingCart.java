package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ModelShoppingCart;

import java.util.Objects;
/***
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 * This class is model for Shopping cart objects which created in ShoppingCartDao and ShoppingCart.jsp file.
 * Also in other classes have been created method which add int shoppingcart Database different models (main plate,
 * power unit, processor, RAM Memory and video card).
 */
public class ShoppingCart {
    /**
     * Field at id shopping cart
     */
    private  int id;
    /**
     * Field at name shopping cart
     */
    private String name;
    /**
     *Field price at shopping cart
     */
    private int price;
    /**
     * Field count at shopping cart
     */
    private int counts;

    /**
     *Constructor for created new shopping cart
     */
    public ShoppingCart(){ }

    /**
     *
     * @param id
     * Constructor for created new shopping cart by id
     */
   public ShoppingCart(int id){
        this.id = id;
   }

    /**
     *
     * @return id at shopping cart object
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id by shopping cart object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name at shopping cart object
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name by shopping cart object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return price at shopping cart
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price by shopping cart object
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return count at shopping cart object
     */
    public int getCounts() {
        return counts;
    }

    /**
     *
     * @param counts by shopping cart object
     */
    public void setCounts(int counts) {
        this.counts = counts;
    }

    /**
     *
     * @param o this other shopping cart object if this exits
     * @return true or false by comparison elements
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return id == that.id && price == that.price && counts == that.counts && name.equals(that.name);
    }

    /**
     *
     * @return hashCode at shopping cart object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, counts);
    }

    /**
     *
     * @return String about information with field shopping cart class
     */
    @Override
    public String toString() {
        return "название: " + name  +
                ", цена: " + price +
                " руб,  кол-во: " + counts;
    }
}
