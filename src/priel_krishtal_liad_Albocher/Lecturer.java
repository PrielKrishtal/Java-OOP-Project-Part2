package priel_krishtal_liad_Albocher;
import java.util.Scanner;
public class Lecturer {
    private String name;
    private int id;
    private String degree;
    private String profession;
    private Committee[] committees;
    private Department department;

    //default constructor
    public Lecturer() {
        
    }


    public Lecturer(String name, int id, String degree, String profession, Committee[] committees, Department department) {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.profession = profession;
        this.committees = committees;
        this.department = department;
    }
    
   

    // update the set functions to be boolean and test input
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setDegree(String degree) {
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


    
}
