package secure;

public class Test {
    private int test_no;
    private String test_name;
    private float test_cost;

    public Test(int test_no, String test_name, float test_cost) {
        this.test_no = test_no;
        this.test_name = test_name;
        this.test_cost = test_cost;
    }

    public int getTest_no() {
        return test_no;
    }

    public String getTest_name() {
        return test_name;
    }

    public float getTest_cost() {
        return test_cost;
    }
    
    
}
