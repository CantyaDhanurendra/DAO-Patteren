package id.uad.ac.plankton.dao.impl;

import id.uad.ac.plankton.dao.StudentDao;
import id.uad.ac.plankton.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhanurendra on 10/10/15.
 */

public class StudentDaoImpl implements StudentDao {

    private final Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Student student) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (id, name,address,email) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getAddress());
        preparedStatement.setString(4, student.getEmail());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Student updatedStudent) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name=?,address=?,email=? WHERE id=?");
        preparedStatement.setString(1, updatedStudent.getName());
        preparedStatement.setString(2, updatedStudent.getAddress());
        preparedStatement.setString(3, updatedStudent.getEmail());
        preparedStatement.setInt(4, updatedStudent.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    @Override
    public Student findById(int id) {
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, address FROM student WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {;
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,name,address,email FROM student");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("address"));
                student.setEmail(resultSet.getString("email"));

                studentList.add(student);
            }

            return studentList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Student> findByNameLike(String name) {return null;}

}
