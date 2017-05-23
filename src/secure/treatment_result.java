package secure;

public class treatment_result {
    private int admission_no;
    private int treatment_no;
    private String treatment_result;

    public treatment_result(int admission_no, int treatment_no, String treatment_result) {
        this.admission_no = admission_no;
        this.treatment_no = treatment_no;
        this.treatment_result = treatment_result;
    }

    public int getAdmission_no() {
        return admission_no;
    }

    public int getTreatment_no() {
        return treatment_no;
    }

    public String getTreatment_result() {
        return treatment_result;
    }
    
    
}
