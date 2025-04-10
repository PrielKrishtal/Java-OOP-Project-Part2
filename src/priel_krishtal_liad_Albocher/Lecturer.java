package priel_krishtal_liad_Albocher;
public class Lecturer {
    private String name;
    private int id;
    private Degree degree;
    private String profession;
    private Committee[] committees;
    private int numCommittees;
    private Department department;


    public Lecturer(String name, int id, Degree degree, String profession, Committee[] committees, Department department) {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.profession = profession;
        this.committees = committees;
        this.department = department;
        this.committees = new Committee[1];
        numCommittees = 0;
    }

    public String toString() {
        String str = "Name: " + this.name + "\n" +
                     "ID: " + this.id + "\n" +
                     "Degree: " + this.degree + "\n" +
                     "Profession: " + this.profession + "\n";
    
        if (numCommittees > 0) {
            str += "Committees: ";
            for (int i = 0; i < numCommittees; i++) {
                str += this.committees[i].getName();
                if (i < numCommittees - 1) {
                    str += ", ";
                }
            }
            str += "\n";
        }
    
        if (this.department != null) {
            str += "Department: " + this.department.getName() + "\n";
        }
    
        return str;
    }
    
    


    public int getId() {
        return id;
    }

    public Degree getDegree() {
        return degree;
    }

    public String getProfession() {
        return profession;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setDegree(Degree degree) {
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

    public Committee[] getCommittees() {
        return committees;
    }

    public int getNumCommittees() {
        return numCommittees;
    }

    public void setCommittees(Committee[] committees) {
    this.committees = committees;
    if (committees != null) {
        this.numCommittees = committees.length;
    } else {
        this.numCommittees = 0;
    }
}

    
    
    
}
