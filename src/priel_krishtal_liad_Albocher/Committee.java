package priel_krishtal_liad_Albocher;

public class Committee {
    private String name;
    private Lecturer[] lecturers;
    private Lecturer headOfComm;

    public Commitees(String name, String[] lecturers, String headOfComm){
        this.name = name;
        this.lecturers = lecturers;
        this.headOfComm = headOfComm;
    }
}
