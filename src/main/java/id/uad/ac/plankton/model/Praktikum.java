package id.uad.ac.plankton.model;

/**
 * Created by dhanurendra on 17/10/15.
 */
public class Praktikum {
    private int id;
    private int idasisten;
    private String matkul;
    private int nilai;

    public Praktikum(){}

    public Praktikum(int id, int idasisten, String matkul, int nilai){
        this.id = id;
        this.idasisten = idasisten;
        this.matkul = matkul;
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdasisten() {
        return idasisten;
    }

    public void setIdasisten(int idasisten) {
        this.idasisten = idasisten;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public int getNilai() { return nilai; }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
