package id.uad.ac.plankton.dao.impl;

import id.uad.ac.plankton.dao.PraktikumDao;
import id.uad.ac.plankton.model.Asisten;
import id.uad.ac.plankton.model.Praktikum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by dhanurendra on 17/10/15.
 */
public class PraktikumDaoImpl implements PraktikumDao {

    private final Connection connection;

    public PraktikumDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Praktikum praktikum) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO praktikum(id, id_asisten, matkul, nilai) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, praktikum.getId());
        preparedStatement.setInt(2, praktikum.getId_asisten());
        preparedStatement.setString(3, praktikum.getMatkul());
        preparedStatement.setInt(4, praktikum.getNilai());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Praktikum updatePraktikum) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE praktikum SET id_asisten=?, matkul=?, nilai=?  WHERE id=?");
        preparedStatement.setInt(1, updatePraktikum.getId_asisten());
        preparedStatement.setString(2, updatePraktikum.getMatkul());
        preparedStatement.setInt(3, updatePraktikum.getNilai());
        preparedStatement.setInt(4, updatePraktikum.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM praktikum WHERE id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    @Override
    public Praktikum findById(int id) {
        Praktikum praktikum= new Praktikum();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_asisten, matkul, nilai FROM praktikum WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                praktikum.setMatkul(resultSet.getString("matkul"));
                praktikum.setNilai(resultSet.getInt("nilai"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return praktikum;
    }

    @Override
    public List<Praktikum> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,id_asisten,matkul,nilai FROM praktikum");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Praktikum> praktikumList= new ArrayList<>();
            while (resultSet.next()) {
                Praktikum praktikum = new Praktikum();

                praktikum.setId(resultSet.getInt("id"));
                praktikum.setId_asisten(resultSet.getInt("id_asisten"));
                praktikum.setMatkul(resultSet.getString("matkul"));
                praktikum.setNilai(resultSet.getInt("nilai"));

                praktikumList.add(praktikum);
            }

            return praktikumList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Praktikum> findByNameLike(String name) {return null;}
}
