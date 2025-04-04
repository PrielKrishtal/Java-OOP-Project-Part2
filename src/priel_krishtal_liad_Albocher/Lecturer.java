package priel_krishtal_liad_Albocher;

public class Lecturer {
    private String name;
    private int id;
    private String degree;
    private String profession;
    private Commitees[] committees;
    private Department department;

    public Lecturer(String name, int id, String degree, String profession){
        this.name = name;
        this.id = id;
        this degree = degree;
        this.profession = profession;
    }
}
