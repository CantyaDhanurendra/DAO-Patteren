package id.uad.ac.plankton.dao.impl;

import id.uad.ac.plankton.dao.AsistenDao;
import id.uad.ac.plankton.model.Asisten;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhanurendra on 17/10/15.
 */
public class AsistenDaoImpl implements AsistenDao {

    private final Connection connection;

    public AsistenDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Asisten asisten) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO asisten (idAsisten, nameAsisten,addressAsisten) VALUES (?,?,?)");
        preparedStatement.setInt(1, asisten.getIdAsisten());
        preparedStatement.setString(2, asisten.getNameAsisten());
        preparedStatement.setString(3, asisten.getAddressAsisten());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Asisten updateAsisten) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE asisten SET nameAsisten=?,addressAsisten=? WHERE idAsisten=?");
        preparedStatement.setString(1, updateAsisten.getNameAsisten());
        preparedStatement.setString(2, updateAsisten.getAddressAsisten());
        preparedStatement.setInt(3, updateAsisten.getIdAsisten());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int idAsisten) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM asisten WHERE idAsisten=?");
        preparedStatement.setInt(1, idAsisten);
        preparedStatement.executeUpdate();

    }

    @Override
    public Asisten findById(int idAsisten) {
        Asisten asisten = new Asisten();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT nameAsisten, addressAsisten FROM asisten WHERE idAsisten=?");
            preparedStatement.setInt(1, idAsisten);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                asisten.setNameAsisten(resultSet.getString("nameAsisten"));
                asisten.setAddressAsisten(resultSet.getString("addressAsisten"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asisten;
    }

    @Override
    public List<Asisten> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT idAsisten,nameAsisten,addressAsisten FROM asisten");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Asisten> asistenList= new ArrayList<>();
            while (resultSet.next()) {
                Asisten asisten= new Asisten();

                asisten.setIdAsisten(resultSet.getInt("idAsisten"));
                asisten.setNameAsisten(resultSet.getString("nameAsisten"));
                asisten.setAddressAsisten(resultSet.getString("addressAsisten"));

                asistenList.add(asisten);
            }

            return asistenList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Asisten> findByNameLike(String name) {return null;}

}
