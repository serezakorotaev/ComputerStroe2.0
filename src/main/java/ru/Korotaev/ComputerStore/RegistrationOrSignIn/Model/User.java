package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model;

import java.io.Serializable;
import java.util.Objects;
/***
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 * This class is model for User objects. This class is used for created new
 * user in database or check for the existence of a user. Fields login and password
 * are needed for user's registrations or his sign in.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2041275512219239990L;
    /**
     * Field id at user
     */
    private int id;
    /**
     * Field login at user for registration or sign in
     */
    private String login;
    /**
     * Field password at user for registration or sign in
     */
    private String password;

    /**
     *
     * @param login for registration or sign in user and save in table
     *              in user's table
     * @param password for registration or sign in user and save in table
     *                    in user's table
     *
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Constructor for create new user object
     */
    public User(){}

    /**
     *
     * @return id this user
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id by user object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return login this user
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login by user object
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return password this user object
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password by user object
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param o this is other user with other login amd password
     * @return true or false if this login doesn't match with other login
     * and passwords accordingly
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && login.equals(user.login) && password.equals(user.password);
    }

    /**
     *
     * @return hashCode at user object by id, login,password
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    /**
     *
     * @return String with information about with user
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
