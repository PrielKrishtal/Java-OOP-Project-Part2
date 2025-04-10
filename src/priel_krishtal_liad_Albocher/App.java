package priel_krishtal_liad_Albocher;
import java.util.Scanner;

public class App {
    // ***************************************
    // Lecturer Creation functions
    // ***************************************
    public static Committee getValidatedCommitteeByName(CollegeManagement college) {
        Scanner s = new Scanner(System.in);
        Committee committee;
        String commName;
    
        do {
            System.out.print("Enter committee name: ");
            commName = s.nextLine();
            committee = college.findCommitteeByName(commName);
    
            if (committee == null) {
                System.out.println("Committee not found. Please enter an existing committee name.");
            }
        } while (committee == null);
    
        return committee;
    }


    public static Committee[] chooseCommittees(CollegeManagement college) {

        if (college.getNumCommittees() == 0) {
            System.out.println("No committees available. Skipping committee selection.");
            return null;
        }

        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of committees to assign lecturer to (0 for none): ");
        int numToAssign = s.nextInt();
        s.nextLine();
    
        //input validation check
        while (numToAssign < 0 || numToAssign > college.getNumCommittees()) {
            System.out.print("Invalid number. Please enter a number between 0 and " + college.getNumCommittees() + ": ");
            numToAssign = s.nextInt();
            s.nextLine();
        }
        if (numToAssign == 0){
            return null;
        }
        Committee[] assignedCommittees = new Committee[numToAssign];

        for (int i = 0; i < numToAssign; i++) {
            System.out.println("Committee #" + (i + 1) + ":");
            assignedCommittees[i] = getValidatedCommitteeByName(college);
        }
    
        return assignedCommittees;
    }



    public static Lecturer createLecturer(CollegeManagement college) {
        System.out.println("--- Creating a new Lecturer ---");
        Scanner s = new Scanner(System.in);
        
        String lecturerName;
        do {
            System.out.print("Enter lecturer name: ");
            lecturerName = s.nextLine();
            if (college.findLecturerByName(lecturerName)!=null) {
                System.out.println("Lecturer name already exists! Please enter a new name.");
            }
        } while (college.findLecturerByName(lecturerName)!=null);
        
        System.out.print("Enter lecturer ID: ");
        int lecturerId = s.nextInt();
        s.nextLine();
        
        
        Degree degree = null;
        do {
            System.out.print("Enter lecturer degree (BA, MA, PHD, DR): ");
            String lecturerDegree = s.nextLine().toUpperCase();

            for (Degree d : Degree.values()) {
                if (d.name().equals(lecturerDegree)) {
                    degree = d;
                    break;
                }
            }

            if (degree == null) {
                System.out.println("Invalid degree. Please enter one of: BA, MA, PHD, DR");
            }

        } while (degree == null);
        


        
        System.out.print("Enter lecturer profession: ");
        String lecturerProfession = s.nextLine();


        Committee[] lecturerCommittees = chooseCommittees(college);

        Department chosenDepartment = chooseDepartment(college);
        
        System.out.println("Lecturer added successfully.");
        Lecturer lecturer = new Lecturer(lecturerName, lecturerId, degree, lecturerProfession, lecturerCommittees, chosenDepartment);
        return lecturer;
    }


    public static Department chooseDepartment(CollegeManagement college) {
        if (college.getNumDepartments() == 0) {
            System.out.println("No departments available. Skipping department selection.");
            return null;
        }
    
        System.out.print("Would you like to assign a department to this lecturer? (yes/no): ");
        Scanner s = new Scanner(System.in);
        String answer = s.nextLine();
    
        if (!answer.equalsIgnoreCase("yes")) {
            return null;
        }
    
        return getValidatedDepartmentByName(college);
    }


    public static Department getValidatedDepartmentByName(CollegeManagement college) {
        Department department;
        String depName;
        Scanner s = new Scanner(System.in);
    
        do {
            System.out.print("Enter department name: ");
            depName = s.nextLine();
            department = college.findDepartmentByName(depName);
    
            if (department == null) {
                System.out.println("Department not found. Please enter an existing department name.");
            }
        } while (department == null);
    
        return department;
    }

    // ***************************************
    // Committee Creation functions
    // ***************************************
    public static Lecturer getValidatedChairperson(CollegeManagement college) {
        Scanner s = new Scanner(System.in);
        Lecturer chairPerson = null;
    
        do {
            System.out.print("Enter chairperson's name: ");
            String name = s.nextLine();
            chairPerson = college.findLecturerByName(name);
    
            if (chairPerson == null) {
                System.out.println("Lecturer not found.");
            } 
            else if (!(chairPerson.getDegree() == Degree.DR || chairPerson.getDegree() == Degree.Professor)) {
                System.out.println("Chairperson must have at least a DR or Professor degree.");
                chairPerson = null; // force re-entry
            }
    
        } while (chairPerson == null);
    
        return chairPerson;
    }
    

    public static Committee createCommittee(CollegeManagement college)  {
        System.out.println("--- Add a New Committee ---");

        if (college.getNumLecturers() == 0) {
            System.out.println("No lecturers in the system. Cannot assign a chairperson.");
            return null;
        }
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter committee name: ");
        String committeeName = s.nextLine();
    
        while (college.findCommitteeByName(committeeName)!=null) {
            System.out.print("A committee with this name already exists. Enter a different name: ");
            committeeName = s.nextLine();
        }
    
        System.out.print("How many lecturers would you like to assign?: ");
        int numAssigned = s.nextInt();
        s.nextLine(); // Consume leftover newline
        Lecturer[] assignedLecturers = new Lecturer[numAssigned];

        Lecturer chairPerson = getValidatedChairperson(college);

        for(int i=0;i<numAssigned;i++){
            System.out.print("Enter the name of lecturer #"+(i+1)+": ");
            String lectName = s.nextLine();
            while(college.findLecturerByName(lectName)==null){
                System.out.println("Error: Lecturer not found. Please enter a valid lecturer name.");
                lectName = s.nextLine();
            }
            while(lectName.equals(chairPerson.getName())){
                System.out.println("Chairperson should not be in the list of committee members. enter the name of lecturer #"+(i+1)+":");
                lectName = s.nextLine();
            }

            assignedLecturers[i] = college.findLecturerByName(lectName);
        }
        return new Committee(committeeName, assignedLecturers, chairPerson);
    }
    
    

    // ***************************************
    // Department Creation functions
    // ***************************************
    

    
    
    
    public static void main(String[] args){
         // Submitters: Priel Krishtal , Liad Albocher
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Collage name:");
		String collegeName = s.nextLine();
        CollegeManagement college = new CollegeManagement(collegeName);
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
                    Lecturer newLecturer = createLecturer(college);
                    college.addLecturer(newLecturer);
                    
                    break;
                case 2:
                    // Add Committee
                    Committee newCommittee = createCommittee(college);
                    college.addCommittee(newCommittee);
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
                    for (int i = 0; i < college.getNumLecturers(); i++) {
                        System.out.println(college.getLecturers()[i].toString());
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
    
        
        s.close();
    }
}
