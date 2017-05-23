
package secure;

public class Nurse extends Employee{
    
    private int nurse_ward_no;

    public Nurse(int nurse_ward_no, String emp_id, String emp_name, int emp_age, String emp_gender, String emp_address, String emp_telephone, float emp_salary_rate, int emp_attendence, float emp_salary) {
        super(emp_id, emp_name, emp_age, emp_gender, emp_address, emp_telephone, emp_salary_rate, emp_attendence, emp_salary);
        this.nurse_ward_no = nurse_ward_no;
    }

    public int getNurse_ward_no() {
        return nurse_ward_no;
    }
    
}
