package id.uad.ac.plankton.model;

/**
 * Created by dhanurendra on 17/10/15.
 */
public class Asisten {
    private int id_asisten;
    private String name_asisten;
    private String address_asisten;

    public Asisten() {}

    public Asisten (int id_asisten, String name_asisten, String address_asisten){
        this.id_asisten = id_asisten;
        this.name_asisten = name_asisten;
        this.address_asisten = address_asisten;
    }


    public int getId_asisten() {
        return id_asisten;
    }

    public void setId_asisten(int id_asisten) {
        this.id_asisten = id_asisten;
    }

    public String getName_asisten() {
        return name_asisten;
    }

    public void setName_asisten(String name_asisten) {
        this.name_asisten = name_asisten;
    }

    public String getAddress_asisten() {
        return address_asisten;
    }

    public void setAddress_asisten(String address_asisten) {
        this.address_asisten = address_asisten;
    }
}
