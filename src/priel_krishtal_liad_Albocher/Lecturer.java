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

    public Lecturer(Lecturer other){
        this.name = other.name;
        this.id = other.id;
        this.degree = other.degree;
        this.profession = other.profession;
        this.committees = other.committees;
        this.department = other.department;
        this.committees = other.committees;
        this.numCommittees = other.numCommittees;
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
        if(this.department == null){
            this.department = department;
        }
        else
            System.out.println("Cannot add more then 1 department for a lecturer");
      
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


    public void addCommittee(Committee committee) {
        // If the committees array hasn't been initialized yet, initialize it.
        if (this.committees == null) {
            this.committees = new Committee[1]; 
            numCommittees = 0;
        }
        // Resize the committees array if it's full.
        if (numCommittees >= committees.length) {
            committees = resizeCommitteeArray(committees);
        }
        // Add the new committee and update the number of committees.
        committees[numCommittees++] = committee;
        System.out.println("Committee " + committee.getName() + " added to lecturer " + this.getName());
    }
    
    /**
     * Private helper method to double the size of the committees array.
     */
    private Committee[] resizeCommitteeArray(Committee[] arr) {
        Committee[] newArr = new Committee[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i]; // Copy each existing committee into the new array.
        }
        return newArr;
    }
    

    
}
