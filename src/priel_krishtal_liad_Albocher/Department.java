package priel_krishtal_liad_Albocher;
public class Department {
    private String name;
    private int numOfStudents;
    private Lecturer[] lecturers;

    public Department(String name, int numOfStudents, Lecturer[] lecturers) {
        this.name = name;
        this.numOfStudents = numOfStudents;
        this.lecturers = lecturers;
    }
    
}

