package id.uad.ac.plankton;

import id.uad.ac.plankton.dao.impl.StudentDaoImpl;
import id.uad.ac.plankton.dao.impl.AsistenDaoImpl;
import id.uad.ac.plankton.dao.impl.PraktikumDaoImpl;
import id.uad.ac.plankton.dao.StudentDao;
import id.uad.ac.plankton.dao.AsistenDao;
import id.uad.ac.plankton.dao.PraktikumDao;
import id.uad.ac.plankton.db.DatabaseConnection;
import id.uad.ac.plankton.model.Asisten;
import id.uad.ac.plankton.model.Student;
import id.uad.ac.plankton.model.Praktikum;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by dhanurendra on 06/10/15.
 */
public class MainApplication {
    public static void main(String[] args) {
        //Student ak = new Student(2, "Angga Kuncoro", "Sleman","ak@g.com");
        //Student dh = new Student(1, "Cantya Dhanurendra", "Berbah", "da@y.com");
        //Student upst = new Student(1,"Cantya Dhanurendra", "Kaliajir", "dh@y.com");

        //Asisten l = new Asisten(101, "Lukman", "Magelang");
        //Asisten rm = new Asisten(100, "Rahman Gunawan", "Sleman");
        //Asisten upas = new Asisten(100, "Bambang Gunawan", "Jogja");

        //Praktikum pam = new Praktikum(2,101,"PAM",80);
        //Praktikum pwd = new Praktikum(1,100,"PWD",90);
       //Praktikum uppr = new Praktikum(1,100,"BD",95);
        //Praktikum pbps = new Praktikum(2,2,200,"PBPS","A");

        try {
            StudentDao studentDao = new StudentDaoImpl(DatabaseConnection.getInstance().getConnection());
            AsistenDao asistenDao = new AsistenDaoImpl(DatabaseConnection.getInstance().getConnection());
            PraktikumDao praktikumDao = new PraktikumDaoImpl(DatabaseConnection.getInstance().getConnection());

            //studentDao.insert(ak);
            //studentDao.update(upst);
            //studentDao.delete(2);
            //System.out.println("Nama : " + studentDao.findById(1).getName());
            //System.out.println("Alamat : " + studentDao.findById(1).getAddress());

            //asistenDao.insert(l);
            //asistenDao.update(upas);
            //asistenDao.delete(101);
           // System.out.println();
            //System.out.println("Nama Asisten : " + asistenDao.findById(100).getNameasisten());
            //System.out.println("Alamat Aasisten : " + asistenDao.findById(100).getAddressasisten());

            //praktikumDao.insert(pbps);
            //praktikumDao.update(uppr);
            //praktikumDao.delete(2);
            //System.out.println("Matkul : " + praktikumDao.findById(1).getMatkul());
            //System.out.println("Nilai : " + praktikumDao.findById(1).getNilai());

            /*List<Student> studentList = studentDao.findAll();
            for (Student s : studentList) {
                System.out.print(s.getId() + " - ");
                System.out.print(s.getName() + " - ");
                System.out.print(s.getAddress() + " -   ");
                System.out.println(s.getEmail());

            }*/

            /*
            List<Asisten> asistensList = asistenDao.findAll();
            for (Asisten s : asistensList) {
                System.out.print(s.getIdAsisten() + " - ");
                System.out.print(s.getNameAsisten() + " - ");
                System.out.println(s.getAddressAsisten());
            }*/

            /*
            List<Praktikum> praktikumList = praktikumDao.findAll();
            for (Praktikum s : praktikumList) {
                System.out.print(s.getKode() + " - ");
                //System.out.print(s.getIdAsisten() + " - ");
                System.out.print(s.getMataKuliah() + " - ");
                System.out.println(s.getNilai());
            }*/



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
