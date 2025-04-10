package priel_krishtal_liad_Albocher;

public class MainTests{
    public static void main(String[] args) {
        // 1. Create a CollegeManagement instance
        CollegeManagement college = new CollegeManagement("Test College");

        // 2. Create sample lecturers.
        // Assume the Lecturer constructor is: 
        // Lecturer(String name, int id, Degree degree, String profession, Committee[] committees, Department department)
        Lecturer lec1 = new Lecturer("Dr. Alice", 1001, Degree.DR, "Professor", null, null);
        Lecturer lec2 = new Lecturer("Professor Bob", 1002, Degree.Professor, "Senior Lecturer", null, null);
        Lecturer lec3 = new Lecturer("Charlie", 1003, Degree.MA, "Assistant", null, null); // Not eligible as chairperson

        // 3. Add lecturers using the updated addLecturer which returns a new array.
        Lecturer[] currentLecturers = college.getLecturers();
        currentLecturers = college.addLecturer(lec1, currentLecturers);
        college.setLecturers(currentLecturers);
        currentLecturers = college.addLecturer(lec2, college.getLecturers());
        college.setLecturers(currentLecturers);
        currentLecturers = college.addLecturer(lec3, college.getLecturers());
        college.setLecturers(currentLecturers);

        // 4. Print all lecturers using their toString() (assumes Lecturer.toString() is properly formatted)
        System.out.println("=== Lecturers ===");
        for (int i = 0; i < college.getNumLecturers(); i++) {
            System.out.println(college.getLecturers()[i].toString());
            System.out.println("--------------------------");
        }

        // 5. Create a department.
        // Here we create a "Computer Science" department and manually assign lec1 and lec2 to it.
        Lecturer[] deptLecturers = { lec1, lec2 };
        Department csDept = new Department("Computer Science", 200, deptLecturers);
        // For testing, assign the department to the lecturers
        lec1.setDepartment(csDept);
        lec2.setDepartment(csDept);

        // 6. Create a committee manually.
        // We choose lec1 as the chairperson (which is valid because lec1's degree is DR)
        // and assign lec2 as the committee member.
        Lecturer[] committeeMembers = { lec2 };
        Committee committee1 = new Committee("Research Committee", committeeMembers, lec1);
        
        // Use the updated addCommittee function (returns the updated array).
        Committee[] currentCommittees = college.getCommittees();
        currentCommittees = college.addCommittee(committee1, currentCommittees);
        college.setCommittees(currentCommittees);

        // 7. Print committee details. 
        // (Assuming the Committee class has getters for name, chair, and lecturers)
        System.out.println("\n=== Committees ===");
        for (int i = 0; i < college.getNumCommittees(); i++) {
            Committee comm = college.getCommittees()[i];
            System.out.println("Committee Name: " + comm.getName());
            System.out.println("Chairperson: " + comm.getHeadOfComm());
            System.out.print("Committee Members: ");
            // Assuming Committee provides getLecturers() returning a Lecturer[]
            for (Lecturer l : comm.getLecturers()) {
                System.out.print(l.getName() + "  ");
            }
            System.out.println("\n--------------------------");
        }

         
        


        // 8. Print department details.
        System.out.println("\n=== Department ===");
        System.out.println("Department Name: " + csDept.getName());
        System.out.println("Number of Students: " + csDept.getNumOfStudents());
        System.out.print("Department Lecturers: ");
        for (Lecturer l : csDept.getLecturers()) {
            System.out.print(l.getName() + "  ");
        }
        System.out.println("\n--------------------------");

        // 9. End of MainTest
    }
}
