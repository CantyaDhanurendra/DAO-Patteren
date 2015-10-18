package id.uad.ac.plankton.dao;

import id.uad.ac.plankton.model.Praktikum;


import java.sql.SQLException;
import java.util.List;


/**
 * Created by dhanurendra on 17/10/15.
 */
public interface PraktikumDao {

    void insert(Praktikum praktikum) throws SQLException;

    void update(Praktikum updatePraktikum) throws SQLException;

    void delete(int kode) throws SQLException;

    Praktikum findById(int kode) throws SQLException;

    List<Praktikum> findAll();

    List<Praktikum> findByNameLike(String id);

}
