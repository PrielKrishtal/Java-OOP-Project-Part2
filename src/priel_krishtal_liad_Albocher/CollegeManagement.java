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
        menu();
    }

    public void menu(){
        Scanner s = new Scanner(System.in);
        int choice;
        System.out.print("Enter choice: ");
		collegeName = s.nextLine();
        do{

            // Display menu
            System.out.println("\nMenu:");
            System.out.println("0 - Exit");
            System.out.println("1 - Add Lecturer");
            System.out.println("2 - Add Committee");
            System.out.println("3 - Add a member to the committee");
            System.out.println("4 - Update head of committee");
            System.out.println("5 - Remove a member from the committee");
            System.out.println("6 - Add department");
            System.out.println("7 - Show Average Salary of All Lecturers");
            System.out.println("8 - Show Average Salary of a chosen Department");
            System.out.println("9 - display full details for all lecturer");
            System.out.println("10 - display full details for all committees");
            System.out.print("Enter your choice: ");

            // Read user choice
            choice = s.nextInt();
            s.nextLine();  // Consume newline
            switch (choice) {
                case 0:
                    // Exit
                    break;
                case 1:
                    // Add Lecturer
                    break;
                case 2:
                    // Add Committee
                    break;
                case 3:
                    // Add a member to the committee
                    break;
                case 4:
                    // Update head of committee
                    break;
                case 5:
                    // Remove a member from the committee
                    break;
                case 6:
                    // Add department
                    break;
                case 7:
                    // Show Average Salary of All Lecturers
                    break;
                case 8:
                    // Show Average Salary of a chosen Department
                    break;
                case 9:
                    // Display full details for all lecturers
                    break;
                case 10:
                    // Display full details for all committees
                    break;
                default:
                    // Option not recognized
                    break;
            }
            
           
            
           
        
        }while (choice != 0);

    }

}
