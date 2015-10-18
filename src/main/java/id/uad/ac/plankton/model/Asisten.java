package id.uad.ac.plankton.model;

/**
 * Created by dhanurendra on 17/10/15.
 */
public class Asisten {
    private int idAsisten;
    private String nameAsisten;
    private String addressAsisten;

    public Asisten() {}

    public Asisten (int idAsisten, String nameAsisten, String addressAsisten){
        this.idAsisten = idAsisten;
        this.nameAsisten = nameAsisten;
        this.addressAsisten = addressAsisten;
    }


    public int getIdAsisten() {
        return idAsisten;
    }

    public void setIdAsisten(int idAsisten) {
        this.idAsisten = idAsisten;
    }

    public String getNameAsisten() {
        return nameAsisten;
    }

    public void setNameAsisten(String nameAsisten) {
        this.nameAsisten = nameAsisten;
    }

    public String getAddressAsisten() {
        return addressAsisten;
    }

    public void setAddressAsisten(String addressAsisten) {
        this.addressAsisten = addressAsisten;
    }
}
