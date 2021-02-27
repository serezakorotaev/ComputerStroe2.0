package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model;


/***
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 *This class has basic information about connection to dataBase. It is Driver this DB,
 * name this DB, localhost this DB, User name, his password. This class is used in
 * different DAO classes for connection to different tables.
 */
public class ConnectionData {
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String DB = "ComputerStore";
    public static final String URL = "jdbc:postgresql://localhost:5432/ComputerStore";
    public static final String USER = "postgres";
    public static final String PASSWORD = "Sae252721";


}
