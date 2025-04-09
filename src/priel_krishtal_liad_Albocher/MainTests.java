package priel_krishtal_liad_Albocher;

public class MainTests {
    public static void main(String[] args) {

        // Create a lecturer (temporarily without committees and department to avoid circular reference issues)
        Lecturer lecturer1 = new Lecturer("Dr. Alice Johnson", 12345, "Ph.D.", "Professor", null, null);

        // Array with this lecturer to assign to the department and committees
        Lecturer[] lecturersArray = { lecturer1 };

        // Create department clearly
        Department csDepartment = new Department("Computer Science", 250, lecturersArray);
        
        // Create committees clearly
        Committee researchCommittee = new Committee("Research Committee", lecturersArray, lecturer1);
        Committee ethicsCommittee = new Committee("Ethics Committee", lecturersArray, lecturer1);

        // Lecturer's committees array
        Committee[] lecturerCommittees = { researchCommittee, ethicsCommittee };

        // Assign department and committees explicitly now
        lecturer1.setDepartment(csDepartment);
        lecturer1.setCommittees(lecturerCommittees) ;


        // Print clearly using your toString()
        System.out.println(lecturer1.toString());
    }
}
