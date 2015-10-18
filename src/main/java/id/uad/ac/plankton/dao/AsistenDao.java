package id.uad.ac.plankton.dao;

import id.uad.ac.plankton.model.Asisten;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by dhanurendra on 17/10/15.
 */
public interface AsistenDao {

    void insert(Asisten asisten) throws SQLException;

    void update(Asisten updatedAsisten) throws SQLException;

    void delete(int idAsisten) throws SQLException;

    Asisten findById(int idAsisten) throws SQLException;

    List<Asisten> findAll();

    List<Asisten> findByNameLike(String nameasisten);

}
