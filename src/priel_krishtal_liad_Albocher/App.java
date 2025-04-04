package priel_krishtal_liad_Albocher;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
         // Submitters: Priel Krishtal , Liad Albocher
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Collage name:");
		collegeName = s.nextLine();
        CollegeManagement currentCollage = new CollegeManagement(collegeName);
        s.close();
    }
}
