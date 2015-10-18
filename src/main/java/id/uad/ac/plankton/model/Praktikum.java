package id.uad.ac.plankton.model;

/**
 * Created by dhanurendra on 17/10/15.
 */
public class Praktikum {
    //private int id;
    //private int idAsisten;

    private int kode;
    private Asisten asisten;
    private Student student;
    private String mataKuliah;
    private String nilai;

    public Praktikum(){}

    public Praktikum(int kode, Asisten asisten, Student student, String mataKuliah, String nilai){
        this.kode = kode;
        this.asisten = asisten;
        this.student = student;
        this.mataKuliah = mataKuliah;
        this.nilai = nilai;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
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

    public String getMataKuliah() { return mataKuliah;}

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
}
