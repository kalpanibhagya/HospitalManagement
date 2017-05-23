package secure;

public class Treatment {
    private int treatment_no;
    private String treatment_name;
    private float treatment_cost;

    public Treatment(int treatment_no, String treatment_name, float treatment_cost) {
        this.treatment_no = treatment_no;
        this.treatment_name = treatment_name;
        this.treatment_cost = treatment_cost;
    }

    public int getTreatment_no() {
        return treatment_no;
    }

    public String getTreatment_name() {
        return treatment_name;
    }

    public float getTreatment_cost() {
        return treatment_cost;
    }
    
    
}
