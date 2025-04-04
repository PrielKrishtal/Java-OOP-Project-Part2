package priel_krishtal_liad_Albocher;
import java.util.Scanner;

public class App {
    public static boolean isStrInArr(String[] arr, String item) {
        if (arr == null) {
            return false;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(item)) {
                return true;
            }
        }

        return false;
    }
    
    //function that prints the array(only the logical size)
    public static void printArr(String[] arr, int currentSize){
        if (currentSize == 0) {
            System.out.print("Array is still empty");
            return;
        }
        for (int i = 0; i < currentSize; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static String[] resizeArr(String[] arr) {
        String[] newArr = new String[arr.length*2];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    
    public static String[] insertToArr(String[] arr,int currentSize,String item){
        if (currentSize>= arr.length){ //if the amount of people is bigger than the array size
            arr= resizeArr(arr);
        }
        
        arr[currentSize] = item;
        
        return arr;
    }


    public static void main(String[] args){
         // Submitters: Priel Krishtal , Liad Albocher
        Scanner s = new Scanner(System.in);
        String collegeName;
        int choice;
        int numLecturers = 0, numCommittees = 0, numDepartments = 0;
        String[] lecturers, committees, departments;

        lecturers = new String[1];
        committees = new String[1];
        departments = new String[1];

        
        System.out.print("Enter Collage name:");
		collegeName = s.nextLine();  // Read user input
        do{

            // Display menu
            System.out.println("\nMenu:");
            System.out.println("0 - Exit");
            System.out.println("1 - Add Lecturer");
            System.out.println("2 - Add Committee");
            System.out.println("3 - Add Department");
            System.out.println("4 - Assign Lecturer to Committee");
            System.out.println("5 - Show Average Salary of All Lecturers (Not Implemented)");
            System.out.println("6 - Show Average Salary of a Department (Not Implemented)");
            System.out.println("7 - Show All Lecturers");
            System.out.println("8 - Show All Committees");
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

        s.close();
    }
}
