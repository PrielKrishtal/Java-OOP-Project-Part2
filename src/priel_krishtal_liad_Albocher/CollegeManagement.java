package priel_krishtal_liad_Albocher;
import java.util.Scanner;
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
    

    // ***************************************
    // Lecturer functions
    // ***************************************
    public void addLecturer(Lecturer lecturer) {
        if (numLecturers >= lecturers.length) {
            lecturers = resizeLecturerArray(lecturers);
        }
        lecturers[numLecturers++] = lecturer;
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
    
    public void addCommittee(Committee committee){
        if (numLecturers >= committees.length) {
            lecturers = resizeLecturerArray(lecturers);
        }
        committees[numLecturers++] = committee;
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
    
    

    
    
    
    
    

   

    

    

}
