package priel_krishtal_liad_Albocher;

public class Committee {
    private String name;
    private Lecturer[] lecturers;
    private Lecturer headOfComm;
    private int numLecturers;

    public Committee(String name, Lecturer[] lecturers, Lecturer headOfComm){
        this.name = name;
        this.lecturers = lecturers;
        this.headOfComm = headOfComm;
        this.numLecturers=0;
    }

    public String getName() {
        return name;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public Lecturer getHeadOfComm() {
        return headOfComm;
    }
    
    public int getNumLecturers() {
        return numLecturers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }

    public void setHeadOfComm(Lecturer headOfComm) {
        this.headOfComm = headOfComm;
    }

    public void setNumLecturers(int numLecturers) {
        this.numLecturers = numLecturers;
    }
    
}
