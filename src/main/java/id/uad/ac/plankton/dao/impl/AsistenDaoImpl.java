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

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO asisten (idasisten, nameasisten,addressasisten) VALUES (?,?,?)");
        preparedStatement.setInt(1, asisten.getIdasisten());
        preparedStatement.setString(2, asisten.getNameasisten());
        preparedStatement.setString(3, asisten.getAddressasisten());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Asisten updateAsisten) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE asisten SET nameasisten=?,addressasisten=? WHERE idasisten=?");
        preparedStatement.setString(1, updateAsisten.getNameasisten());
        preparedStatement.setString(2, updateAsisten.getAddressasisten());
        preparedStatement.setInt(3, updateAsisten.getIdasisten());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int idaisten) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM asisten WHERE idasisten=?");
        preparedStatement.setInt(1, idaisten);
        preparedStatement.executeUpdate();

    }

    @Override
    public Asisten findById(int idasisten) {
        Asisten asisten = new Asisten();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT nameasisten, addressasisten FROM asisten WHERE idasisten=?");
            preparedStatement.setInt(1, idasisten);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                asisten.setNameasisten(resultSet.getString("nameasisten"));
                asisten.setAddressasisten(resultSet.getString("addressasisten"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asisten;
    }

    @Override
    public List<Asisten> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT idasisten,nameasisten,addressasisten FROM asisten");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Asisten> asistenList= new ArrayList<>();
            while (resultSet.next()) {
                Asisten asisten= new Asisten();

                asisten.setIdasisten(resultSet.getInt("idasisten"));
                asisten.setNameasisten(resultSet.getString("nameasisten"));
                asisten.setAddressasisten(resultSet.getString("addressasisten"));

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
