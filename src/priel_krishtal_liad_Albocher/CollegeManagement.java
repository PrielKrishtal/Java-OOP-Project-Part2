package priel_krishtal_liad_Albocher;
public class CollegeManagement {
    private String collegeName;
    private Lecturer[] lecturers;
    private Department[] departments;
    private Committee[] committees;
    private int numLecturers, numDepartments, numCommittees;
    
    public CollegeManagement(String name){
        this.collegeName = name;
        lecturers = new Lecturer[1];
        departments = new Department[1];
        committees = new Committee[1];
        numLecturers = 0;
        numDepartments = 0;
        numCommittees = 0;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Lecturer[] getLecturers() {
        return lecturers;}
    

    public Department[] getDepartments() {
        return departments;}
    

    public Committee[] getCommittees() {
        return committees;}
    

    public int getNumLecturers() {
        return numLecturers;}
    

    public int getNumDepartments() {
        return numDepartments; }
   

    public int getNumCommittees() {
        return numCommittees;}
    
        
    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public void setCommittees(Committee[] committees) {
        this.committees = committees;
    }

    // ***************************************
    // Lecturer functions
    // ***************************************
    
    public Lecturer[] addLecturer(Lecturer lecturer,Lecturer[] arrLect) {
        if (numLecturers >= arrLect.length) {
            arrLect = resizeLecturerArray(arrLect);
        }
        arrLect[numLecturers++] = lecturer;

        return arrLect;//in order to implement the resizing we return by value
    }

    public static Lecturer[] resizeLecturerArray(Lecturer[] arr) {
        Lecturer[] newArr = new Lecturer[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    

    public Lecturer findLecturerByName(String name) {
        for (int i = 0; i < numLecturers; i++) {
            if (lecturers[i].getName().equals(name)) {
                return lecturers[i];
            }
        }
        return null;
    }



    // ***************************************
    // Committee functions
    // ***************************************
   
    public Committee findCommitteeByName(String name) {
        for (int i = 0; i < getNumCommittees(); i++) {
            if (getCommittees()[i].getName().equals(name)) {
                return getCommittees()[i];
            }
        }
        return null;
    }
    
    
    public Committee[] addCommittee(Committee committee,Committee[] arrComm){
        if (numCommittees >= arrComm.length) {
            arrComm = resizeCommitteesArray(arrComm);
        }
        arrComm[numCommittees++] = committee;
        return arrComm;
        
    }
   

    public static Committee[] resizeCommitteesArray(Committee[] arr) {
        Committee[] newArr = new Committee[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    
    // ***************************************
    // Department functions
    // ***************************************
    public Department findDepartmentByName(String name) {
        for (int i = 0; i < numDepartments; i++) {
            if (departments[i].getName().equals(name)) {
                return departments[i];
            }
        }
        return null;
    }
    
    public Department[] addDepartment(Department Department,Department[] arrComm){
        if (numDepartments >= arrComm.length) {
            arrComm = resizeDepartmentArray(arrComm);
        }
        arrComm[numDepartments++] = Department;
        return arrComm;
        
    }
   

    public static Department[] resizeDepartmentArray(Department[] arr) {
        Department[] newArr = new Department[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    

}
