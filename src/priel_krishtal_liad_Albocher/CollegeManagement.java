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
    public static Lecturer[] resizeLecturerArray(Lecturer[] arr) {
        Lecturer[] newArr = new Lecturer[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    
    
    public Lecturer createLecturer() {
        System.out.println("--- Creating a new Lecturer ---");
        Scanner s = new Scanner(System.in);
        
        String lecturerName;
        do {
            System.out.print("Enter lecturer name: ");
            lecturerName = s.nextLine();
            if (lecturerNameExists(lecturerName)) {
                System.out.println("Lecturer name already exists! Please enter a new name.");
            }
        } while (lecturerNameExists(lecturerName));
        
        System.out.print("Enter lecturer ID: ");
        int lecturerId = s.nextInt();
        s.nextLine();
        
        System.out.print("Enter lecturer degree: ");
        String lecturerDegree = s.nextLine();
        
        System.out.print("Enter lecturer profession: ");
        String lecturerProfession = s.nextLine();


        Committee[] lecturerCommittees = chooseCommittees();

        Department chosenDepartment = chooseDepartment();
        
        System.out.println("Lecturer added successfully.");
        Lecturer lecturer = new Lecturer(lecturerName, lecturerId, lecturerDegree, lecturerProfession, lecturerCommittees, chosenDepartment);
        return lecturer;
    }
    
    
    
    public Committee findCommitteeByName(String name) {
        for (int i = 0; i < numCommittees; i++) {
            if (committees[i].getName().equals(name)) {
                return committees[i];
            }
        }
        return null;
    }
    public Committee getValidatedCommitteeByName() {
        Scanner s = new Scanner(System.in);
        Committee committee;
        String commName;
    
        do {
            System.out.print("Enter committee name: ");
            commName = s.nextLine();
            committee = findCommitteeByName(commName);
    
            if (committee == null) {
                System.out.println("Committee not found. Please enter an existing committee name.");
            }
        } while (committee == null);
    
        return committee;
    }
    public Committee[] chooseCommittees() {

        if (numCommittees == 0) {
            System.out.println("No committees available. Skipping committee selection.");
            return null;
        }

        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of committees to assign lecturer to (0 for none): ");
        int numToAssign = s.nextInt();
        s.nextLine();
    
        //input validation check
        while (numToAssign < 0 || numToAssign > numCommittees) {
            System.out.print("Invalid number. Please enter a number between 0 and " + numCommittees + ": ");
            numToAssign = s.nextInt();
            s.nextLine();
        }
        if (numToAssign == 0){
            return null;
        }
        Committee[] assignedCommittees = new Committee[numToAssign];

        for (int i = 0; i < numToAssign; i++) {
            System.out.println("Committee #" + (i + 1) + ":");
            assignedCommittees[i] = getValidatedCommitteeByName();
        }
    
        return assignedCommittees;
    }
    

    private Department findDepartmentByName(String name) {
        for (int i = 0; i < numDepartments; i++) {
            if (departments[i].getName().equals(name)) {
                return departments[i];
            }
        }
        return null;
    }
    private Department getValidatedDepartmentByName() {
        Department department;
        String depName;
        Scanner s = new Scanner(System.in);
    
        do {
            System.out.print("Enter department name: ");
            depName = s.nextLine();
            department = findDepartmentByName(depName);
    
            if (department == null) {
                System.out.println("Department not found. Please enter an existing department name.");
            }
        } while (department == null);
    
        return department;
    }
    private Department chooseDepartment() {
        if (numDepartments == 0) {
            System.out.println("No departments available. Skipping department selection.");
            return null;
        }
    
        System.out.print("Would you like to assign a department to this lecturer? (yes/no): ");
        Scanner s = new Scanner(System.in);
        String answer = s.nextLine();
    
        if (!answer.equalsIgnoreCase("yes")) {
            return null;
        }
    
        return getValidatedDepartmentByName();
    }
    

    private boolean committeeNameExists(String name) {
        for (int i = 0; i < numCommittees; i++) {
            if (committees[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private Lecturer findLecturerByName(String name) {
        for (int i = 0; i < numLecturers; i++) {
            if (lecturers[i].getName().equals(name)) {
                return lecturers[i];
            }
        }
        return null;
    }
    
    private void addCommittee() {
        System.out.println("--- Add a New Committee ---");
    
        Scanner s = new Scanner(System.in);
        System.out.print("Enter committee name: ");
        String committeeName = s.nextLine();
    
        while (committeeNameExists(committeeName)) {
            System.out.print("A committee with this name already exists. Enter a different name: ");
            committeeName = s.nextLine();
        }
    
        if (numLecturers == 0) {
            System.out.println("No lecturers in the system. Cannot assign a chairperson.");
            return;
        }
    
        System.out.print("Enter name of the chairperson (must be an existing lecturer): ");
        String chairName = s.nextLine();
        Lecturer chair = findLecturerByName(chairName);
    
       
    }
    

    public void addLecturer(Lecturer lecturer) {
        if (numLecturers >= lecturers.length) {
            lecturers = resizeLecturerArray(lecturers);
        }
        lecturers[numLecturers++] = lecturer;
    }


    public boolean lecturerNameExists(String name) {
        for (int i = 0; i < numLecturers; i++) {
            if (lecturers[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void menu(){
        Scanner s = new Scanner(System.in);
        int choice;
        
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

            choice = s.nextInt();
            s.nextLine(); 
            switch (choice) {
                case 0:
                    // Exit
                    break;
                case 1:
                    // Add Lecturer
                    Lecturer newLecturer = createLecturer();
                    addLecturer(newLecturer);
                    
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
                    for (int i = 0; i < numLecturers; i++) {
                        System.out.println(lecturers[i].toString());
                    }
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
