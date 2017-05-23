
package secure;

public class Doctor extends Employee{
    
    private String doctor_LC;
    private String doctor_email;
    private String specialized_area;

    public Doctor(String doctor_LC, String doctor_email, String specialized_area, String emp_id, String emp_name, int emp_age, String emp_gender, String emp_address, String emp_telephone, float emp_salary_rate, int emp_attendence, float emp_salary) {
        super(emp_id, emp_name, emp_age, emp_gender, emp_address, emp_telephone, emp_salary_rate, emp_attendence, emp_salary);
        this.doctor_LC = doctor_LC;
        this.doctor_email = doctor_email;
        this.specialized_area = specialized_area;
    }

    public String getDoctor_LC() {
        return doctor_LC;
    }

    public String getDoctor_email() {
        return doctor_email;
    }

    public String getSpecialized_area() {
        return specialized_area;
    }
    
}
