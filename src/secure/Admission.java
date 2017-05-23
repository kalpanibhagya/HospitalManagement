
package secure;
import java.sql.*;

public class Admission {
    private int admission_no;
    private Date admitted_date;
    private Date dischagred_date;
    private int days_stayed;
    private int physican_no;
    private String confirmed_cid;
    private String leading_cid;
    private String patient_nic;
    private float payment;
    private int ward_no;

    public Admission(int admission_no, Date admitted_date, Date dischagred_date, int days_stayed, int physican_no, String confirmed_cid, String leading_cid, String patient_nic, float payment, int ward_no) {
        this.admission_no = admission_no;
        this.admitted_date = admitted_date;
        this.dischagred_date = dischagred_date;
        this.days_stayed = days_stayed;
        this.physican_no = physican_no;
        this.confirmed_cid = confirmed_cid;
        this.leading_cid = leading_cid;
        this.patient_nic = patient_nic;
        this.payment = payment;
        this.ward_no = ward_no;
    }

    public int getAdmission_no() {
        return admission_no;
    }

    public Date getAdmitted_date() {
        return admitted_date;
    }

    public Date getDischagred_date() {
        return dischagred_date;
    }

    public int getDays_stayed() {
        return days_stayed;
    }

    public int getPhysican_no() {
        return physican_no;
    }

    public String getConfirmed_cid() {
        return confirmed_cid;
    }

    public String getLeading_cid() {
        return leading_cid;
    }

    public String getPatient_nic() {
        return patient_nic;
    }

    public float getPayment() {
        return payment;
    }

    public int getWard_no() {
        return ward_no;
    }
    
}
