package id.uad.ac.plankton.dao.impl;

import id.uad.ac.plankton.dao.PraktikumDao;
import id.uad.ac.plankton.model.Asisten;
import id.uad.ac.plankton.model.Praktikum;
import id.uad.ac.plankton.model.Student;

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

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO praktikum(kode, id, idAsisten, mataKuliah, nilai) VALUES (?,?,?,?,?)");
        preparedStatement.setInt(1, praktikum.getKode());
        preparedStatement.setInt(2, praktikum.getStudent().getId());
        preparedStatement.setInt(3, praktikum.getAsisten().getIdAsisten());
        preparedStatement.setString(4, praktikum.getMataKuliah());
        preparedStatement.setString(5, praktikum.getNilai());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Praktikum updatePraktikum) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE praktikum SET id=?, idAsisten=?, mataKuliah=?, nilai=?  WHERE kode=?");
        preparedStatement.setInt(1, updatePraktikum.getStudent().getId());
        //preparedStatement.setString(2, updatePraktikum.getAsisten().getIdAsisten());
        preparedStatement.setString(3, updatePraktikum.getNilai());
        preparedStatement.setInt(4, updatePraktikum.getKode());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int kode) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM praktikum WHERE kode=?");
        preparedStatement.setInt(1, kode);
        preparedStatement.executeUpdate();

    }

    @Override
    public Praktikum findById(int kode) {
        Praktikum praktikum= new Praktikum();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT kode, mataKuliah, nilai FROM praktikum WHERE id=?");
            preparedStatement.setInt(1, kode);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                praktikum.setMataKuliah(resultSet.getString("mataKuliah"));
                praktikum.setNilai(resultSet.getString("nilai"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return praktikum;
    }

    @Override
    public List<Praktikum> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT n.kode, s.id, s.name as student_name, a.idAsisten, a.nameAsisten as asisten_name, n.mataKuliah as matakuliah_name, n.nilai From n" +
            " INNER JOIN student s ON s.id = n.id" +
            " INNER JOIN asisten a ON a.idAsisten = n.isAsisten");

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Praktikum> praktikumList= new ArrayList<>();
            while (resultSet.next()) {
                Praktikum praktikum = new Praktikum();
                Student s = new Student();
                Asisten a = new Asisten();

                praktikum.setKode(resultSet.getInt("kode"));
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("student_name"));
                a.setIdAsisten(resultSet.getInt("idAsisten"));
                a.setNameAsisten(resultSet.getString("asisten_name"));
                praktikum.setMataKuliah(resultSet.getString("matakuliah_name"));
                praktikum.setNilai(resultSet.getString("nilai"));

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
