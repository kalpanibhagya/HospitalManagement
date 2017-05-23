
package secure;

public class ExternalPhysician {
    private int physician_id;
    private String physician_name;
    private String physician_address;
    private String physician_telephone;
    
    public ExternalPhysician(int id, String name, String address, String telephone){
        this.physician_id = id;
        this.physician_name = name;
        this.physician_address = address;
        this.physician_telephone = telephone;
    }

    public int getPhysician_id() {
        return physician_id;
    }

    public String getPhysician_name() {
        return physician_name;
    }

    public String getPhysician_address() {
        return physician_address;
    }

    public String getPhysician_telephone() {
        return physician_telephone;
    }
    
    
    
}
