package secure;
import java.sql.Date;

public class Patient {
    private String nic;
    private String Patient_name;
    private Date Patient_DOB;
    private String Patient_age;
    private String Patient_gender;
    private String Patient_address;
    private String Patient_telephone;

    public Patient(String nic, String Patient_name, Date Patient_DOB, String Patient_age, String Patient_gender, String Patient_address, String Patient_telephone) {
        this.nic = nic;
        this.Patient_name = Patient_name;
        this.Patient_DOB = Patient_DOB;
        this.Patient_age = Patient_age;
        this.Patient_gender = Patient_gender;
        this.Patient_address = Patient_address;
        this.Patient_telephone = Patient_telephone;
    }

    public String getNic() {
        return nic;
    }

    public String getPatient_name() {
        return Patient_name;
    }

    public Date getPatient_DOB() {
        return Patient_DOB;
    }

    public String getPatient_age() {
        return Patient_age;
    }

    public String getPatient_gender() {
        return Patient_gender;
    }

    public String getPatient_address() {
        return Patient_address;
    }

    public String getPatient_telephone() {
        return Patient_telephone;
    }
    
    
    
}
