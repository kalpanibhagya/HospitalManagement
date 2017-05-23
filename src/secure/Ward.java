package secure;

public class Ward {
    private int ward_no;
    private String ward_name;
    private String specialized_area;
    
    public Ward(int no, String name, String specialized_area){
        this.ward_no = no;
        this.ward_name = name;
        this.specialized_area = specialized_area;
    }

    public int getWard_no() {
        return ward_no;
    }

    public String getWard_name() {
        return ward_name;
    }

    public String getWard_speciality() {
        return specialized_area;
    }
    
}
