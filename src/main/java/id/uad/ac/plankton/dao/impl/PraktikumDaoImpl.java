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

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO praktikum(idPraktikum, idAsisten, mataKuliah, nilai) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, praktikum.getIdPraktikum());
        preparedStatement.setInt(2, praktikum.getIdAsisten());
        preparedStatement.setString(3, praktikum.getMataKuliah());
        preparedStatement.setInt(4, praktikum.getNilai());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Praktikum updatePraktikum) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE praktikum SET idPraktikum=?, idAsisten=?, mataKuliah=?, nilai=?  WHERE id=?");
        preparedStatement.setInt(1, updatePraktikum.getIdAsisten());
        preparedStatement.setString(2, updatePraktikum.getMataKuliah());
        preparedStatement.setInt(3, updatePraktikum.getNilai());
        preparedStatement.setInt(4, updatePraktikum.getIdPraktikum());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int idPraktikum) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM praktikum WHERE idPraktikum=?");
        preparedStatement.setInt(1, idPraktikum);
        preparedStatement.executeUpdate();

    }

    @Override
    public Praktikum findById(int idPraktikum) {
        Praktikum praktikum= new Praktikum();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT idAsisten, mataKuliah, nilai FROM praktikum WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                praktikum.setMataKuliahl(resultSet.getString("mataKuliah"));
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,idAsisten,mataKuliah,nilai FROM praktikum");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Praktikum> praktikumList= new ArrayList<>();
            while (resultSet.next()) {
                Praktikum praktikum = new Praktikum();

                praktikum.setId(resultSet.getInt("id"));
                praktikum.setIdAsisten(resultSet.getInt("idAsisten"));
                praktikum.setMataKuliahl(resultSet.getString("mataKuliah"));
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
