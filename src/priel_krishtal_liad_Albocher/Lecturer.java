package priel_krishtal_liad_Albocher;
import java.util.Scanner;
public class Lecturer {
    private String name;
    private int id;
    private String degree;
    private String profession;
    private Committee[] committees;
    private Department department;

    public Lecturer(String name, int id, String degree, String profession, Committee[] committees, Department department) {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.profession = profession;
        this.committees = committees;
        this.department = department;
    }
    
    public String getName(){
        return this.name;
    }


    
    
}
