package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.Computer;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;

/***
 *This Dao class has method for computer's classes. It is select all computer's components if id equally specific value
 * and update count computer in database with id equally specific value.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class ComputerDao {
    /**
     * @param computer - is Computer object with specified id by which found name,
     *                 main plate, power unit, processor, RAM Memory, Video card and count.
     * @see Computer
     */
    public void select(Computer computer) {
        final String SELECT_QUERY = "Select * from madecomputers where id =?";
        try (
                Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setInt(1 , computer.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                computer.setName(resultSet.getString("name"));
                computer.setManeplate(resultSet.getString("maneplate"));
                computer.setPowerunit(resultSet.getString("powerunit"));
                computer.setProcessor(resultSet.getString("processor"));
                computer.setRammemory(resultSet.getString("rammemory"));
                computer.setVideocard(resultSet.getString("videocard"));
                computer.setCount(resultSet.getInt("counts"));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * @param count - is value by which update count in warehouse about ready-made computer
     * @param id    specified indicator computer
     * @see Computer
     */
    public void updateComputer(int count , int id) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement preparedStatement = connection.prepareStatement("Update madecomputers SET counts=? where id=? ");
            preparedStatement.setInt(1 , count);
            preparedStatement.setInt(2 , id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}