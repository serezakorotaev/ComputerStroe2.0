package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model;


/***
 *This class has basic information about connection to dataBase. It is Driver this DB,
 * name this DB, localhost this DB, User name, his password. This class is used in
 * different DAO classes for connection to different tables.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 */
public class ConnectionData {
    /**
     * Field is driver for connecting to the database
     */
    public static final String DRIVER = "org.postgresql.Driver";
    /**
     * Field is name for connecting to the database
     */
    public static final String DB = "ComputerStore";
    /**
     * Field is url for connecting to the database
     */
    public static final String URL = "jdbc:postgresql://localhost:5432/ComputerStore";
    /**
     * Field is user name for connecting to the database
     */
    public static final String USER = "postgres";
    /**
     * Field is password for connecting to the database
     */
    public static final String PASSWORD = "Sae252721";
}
