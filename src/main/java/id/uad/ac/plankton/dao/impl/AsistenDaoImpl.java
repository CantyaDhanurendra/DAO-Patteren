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

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO asisten (id_asisten, name_asisten,address_asisten) VALUES (?,?,?)");
        preparedStatement.setInt(1, asisten.getId_asisten());
        preparedStatement.setString(2, asisten.getName_asisten());
        preparedStatement.setString(3, asisten.getAddress_asisten());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Asisten updateAsisten) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE asisten SET name_asisten=?,address_asisten=? WHERE id_asisten=?");
        preparedStatement.setString(1, updateAsisten.getName_asisten());
        preparedStatement.setString(2, updateAsisten.getAddress_asisten());
        preparedStatement.setInt(3, updateAsisten.getId_asisten());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id_aisten) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM asisten WHERE id_asisten=?");
        preparedStatement.setInt(1, id_aisten);
        preparedStatement.executeUpdate();

    }

    @Override
    public Asisten findById(int id_asisten) {
        Asisten asisten = new Asisten();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name_asisten, address_asisten FROM asisten WHERE id_asisten=?");
            preparedStatement.setInt(1, id_asisten);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                asisten.setName_asisten(resultSet.getString("name_asisten"));
                asisten.setAddress_asisten(resultSet.getString("address_asisten"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asisten;
    }

    @Override
    public List<Asisten> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_asisten,name_asisten,address_asisten FROM asisten");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Asisten> asistenList= new ArrayList<>();
            while (resultSet.next()) {
                Asisten asisten= new Asisten();

                asisten.setId_asisten(resultSet.getInt("id_asisten"));
                asisten.setName_asisten(resultSet.getString("name_asisten"));
                asisten.setAddress_asisten(resultSet.getString("address_asisten"));

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
