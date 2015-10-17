package id.uad.ac.plankton.model;

/**
 * Created by dhanurendra on 17/10/15.
 */
public class Praktikum {
    //private int id;
    //private int idAsisten;

    private int idPraktikum;
    private Asisten asisten;
    private Student student;
    private String mataKuliah;
    private int nilai;

    public Praktikum(){}

    public Praktikum(int idPraktikum, Asisten asisten, Student student, String mataKuliah, int nilai){
        this.idPraktikum = idPraktikum;
        this.asisten = asisten;
        this.student = student;
        this.mataKuliah = mataKuliah;
        this.nilai = nilai;
    }


    public int getIdPrak() {
        return idPraktikum;
    }

    public void setIdPrak(int idPrak) {
        this.idPraktikum = idPraktikum;
    }

    public Asisten getAsisten() {
        return asisten;
    }

    public void setAsisten(Asisten asisten) {
        this.asisten = asisten;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
