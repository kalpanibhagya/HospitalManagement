package secure;

public class test_result {
    private int admission_no;
    private int test_no;
    private String test_result;

    public test_result(int admission_no, int test_no, String test_result) {
        this.admission_no = admission_no;
        this.test_no = test_no;
        this.test_result = test_result;
    }

    public int getAdmission_no() {
        return admission_no;
    }

    public int getTest_no() {
        return test_no;
    }

    public String getTest_result() {
        return test_result;
    }
    
    
}
