package id.uad.ac.plankton.model;

/**
 * Created by dhanurendra on 17/10/15.
 */
public class Praktikum {
    private int id;
    private int id_asisten;
    private String matkul;
    private int nilai;

    public Praktikum(){}

    public Praktikum(int id, int id_asisten, String matkul, int nilai){
        this.id = id;
        this.id_asisten = id_asisten;
        this.matkul = matkul;
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_asisten() {
        return id_asisten;
    }

    public void setId_asisten(int id_asisten) {
        this.id_asisten = id_asisten;
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
