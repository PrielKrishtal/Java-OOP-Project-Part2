package priel_krishtal_liad_Albocher;

public class Committee {
    private String name;
    private Lecturer[] lecturers;
    private Lecturer headOfComm;

    public Committee(String name, Lecturer[] lecturers, Lecturer headOfComm){
        this.name = name;
        this.lecturers = lecturers;
        this.headOfComm = headOfComm;
    }

    public String getName() {
        return name;
    }
    
}
