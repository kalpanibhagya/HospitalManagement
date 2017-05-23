package secure;

public abstract class Employee {
    private String emp_id;
    private String emp_name;
    private int emp_age;
    private String emp_gender;
    private String emp_address;
    private String emp_telephone;
    private float emp_salary_rate;
    private int emp_attendence;
    private float emp_salary;

    public Employee(String emp_id, String emp_name, int emp_age, String emp_gender, String emp_address, String emp_telephone, float emp_salary_rate, int emp_attendence, float emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_age = emp_age;
        this.emp_gender = emp_gender;
        this.emp_address = emp_address;
        this.emp_telephone = emp_telephone;
        this.emp_salary_rate = emp_salary_rate;
        this.emp_attendence = emp_attendence;
        this.emp_salary = emp_salary;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public String getEmp_telephone() {
        return emp_telephone;
    }

    public float getEmp_salary_rate() {
        return emp_salary_rate;
    }

    public int getEmp_attendence() {
        return emp_attendence;
    }

    public float getEmp_salary() {
        return emp_salary;
    }

    
}
