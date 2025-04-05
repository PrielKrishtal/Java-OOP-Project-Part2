package priel_krishtal_liad_Albocher;
public class Lecturer {
    private String name;
    private int id;
    private String degree;
    private String profession;
    private Committee[] committees;
    private int numCommittees;
    private Department department;


    public Lecturer(String name, int id, String degree, String profession, Committee[] committees, Department department) {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.profession = profession;
        this.committees = committees;
        this.department = department;
        committees = new Committee[1];
        numCommittees = 0;
    }

    public String toString(){
        String strCommittiees = "";
        String str = "name: " + this.name + " id: " + this.id + " degree: " + this.degree + " profession: " + this.profession;
        if (numCommittees > 0){
            for (int i = 0; i < numCommittees; i++) {
                strCommittiees += this.committees[i].getName();
            }
            str += "committees: " + strCommittiees;
        }
        if (this.department != null){
            str += "department: " + this.department;
        }
        return str;
    }


    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public String getName() {
        return name;
    }
}
