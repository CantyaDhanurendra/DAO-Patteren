package id.uad.ac.plankton.model;

/**
 * Created by dhanurendra on 17/10/15.
 */
public class Asisten {
    private int idasisten;
    private String nameasisten;
    private String addressasisten;

    public Asisten() {}

    public Asisten (int idasisten, String nameasisten, String addressasisten){
        this.idasisten = idasisten;
        this.nameasisten = nameasisten;
        this.addressasisten = addressasisten;
    }


    public int getIdasisten() {
        return idasisten;
    }

    public void setIdasisten(int idasisten) {
        this.idasisten = idasisten;
    }

    public String getNameasisten() {
        return nameasisten;
    }

    public void setNameasisten(String nameasisten) {
        this.nameasisten = nameasisten;
    }

    public String getAddressasisten() {
        return addressasisten;
    }

    public void setAddressasisten(String addressasisten) {
        this.addressasisten = addressasisten;
    }
}
