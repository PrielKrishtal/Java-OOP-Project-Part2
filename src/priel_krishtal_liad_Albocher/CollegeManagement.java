package priel_krishtal_liad_Albocher;

public class CollegeManagement {
    private String collageName;

    public CollegeManagement(String name){
        this.name = name;
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
                    // Exit program
                    System.out.println("Exiting Program.");
                    break;
                case 1:
                    String newLecturer;
                    do {
                        System.out.print("Enter Lecturer name: ");
                        newLecturer = s.nextLine();
                        if (isStrInArr(lecturers, newLecturer)) {
                            System.out.println("Lecturer name already exists! Please enter a new name.");
                        }
                    } while (isStrInArr(lecturers, newLecturer));
                    lecturers = insertToArr(lecturers, numLecturers, newLecturer);
                    numLecturers++;
                    break;
                case 2:
                    String newCommittee;
                    do {
                        System.out.print("Enter Committee name: ");
                        newCommittee = s.nextLine();
                        if (isStrInArr(committees, newCommittee)) {
                            System.out.println("Committee name already exists! Please enter a new name.");
                        }
                    } while (isStrInArr(committees, newCommittee));
                    committees = insertToArr(committees, numCommittees, newCommittee);
                    numCommittees++;
                    break;
                case 3:
                    String newDepartment;
                    do {
                        System.out.print("Enter Department name: ");
                        newDepartment = s.nextLine();
                        if (isStrInArr(departments, newDepartment)) {
                            System.out.println("Department name already exists! Please enter a new name.");
                        }
                    } while (isStrInArr(departments, newDepartment));
                    departments = insertToArr(departments, numDepartments, newDepartment);
                    numDepartments++;
                    break;
                case 4:
                    // Assign Lecturer to Committee
                    System.out.print("Enter Lecturer name:");
                    String lecturerToAdd= s.nextLine();  // Read user input
                    if(!isStrInArr(lecturers,lecturerToAdd)){
                        System.out.println("Error! given Lecturer doesnt exists");
                        break;
                    }

                    System.out.print("Enter Committee name:");
                    String committee= s.nextLine();  // Read user input
                    if(!isStrInArr(committees,committee)){
                        System.out.println("Error! given committee doesnt exists");
                        break;
                    }
                    break;
                case 5:
                    // Show Average Salary of All Lecturers (Not Implemented)
                    System.out.print("Average Salary of All Lecturers (Not Implemented)");
                    break;
                case 6:
                    // Show Average Salary of a Department (Not Implemented)
                    System.out.print("Average Salary of a Department (Not Implemented)");
                    break;
                case 7:
                    // Show All Lecturers
                    printArr(lecturers,numLecturers);
                    break;
                case 8:
                    // Show All Committees
                    printArr(committees,numCommittees);
                    break;
                default:
                    // Invalid input
                    System.out.println("Invalid choice. Please try again(0-8)");
                    break;
            } 
           
            
           
        
        }while (choice != 0);

    }

}
