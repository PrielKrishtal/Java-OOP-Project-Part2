package priel_krishtal_liad_Albocher;

import java.util.Scanner;

public class Committee {
    private String name;
    private Lecturer[] lecturers;
    private Lecturer headOfComm;
    private int numLecturers;

    public Committee(String name, Lecturer[] lecturers, Lecturer headOfComm){
        this.name = name;
        this.lecturers = lecturers;
        this.headOfComm = headOfComm;
        this.numLecturers=0;
    }

    public String getName() {
        return name;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public Lecturer getHeadOfComm() {
        return headOfComm;
    }
    
    public int getNumLecturers() {
        return numLecturers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }

    public void setHeadOfComm(Lecturer headOfComm) {
        this.headOfComm = headOfComm;
    }

    public void setNumLecturers(int numLecturers) {
        this.numLecturers = numLecturers;
    }

    
     // This method resizes the lecturers array if needed.
     private Lecturer[] resizeLecturersArray(Lecturer[] arr) {
        Lecturer[] newArr = new Lecturer[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }


    public void addMember(Lecturer newMember) {
        // Check that newMember is not the chairperson.
        if (newMember.getName().equalsIgnoreCase(this.headOfComm.getName())) {
            System.out.println("Error: Chairperson cannot be added as a committee member.");
            return;
        }
        // Check if the lecturer is already in the committee.
        for (int i = 0; i < numLecturers; i++) {
            if (lecturers[i].getName().equalsIgnoreCase(newMember.getName())) {
                System.out.println("Error: Lecturer already exists in the committee.");
                return;
            }
        }
        // Resize the array if needed.
        if (numLecturers >= lecturers.length) {
            lecturers = resizeLecturersArray(lecturers);
        }
        lecturers[numLecturers++] = newMember;
        System.out.println("Lecturer " + newMember.getName() + " added successfully to committee " + this.name);
    }

    // Your existing updateCommitteeChair method remains here...
    public void updateCommitteeChair(Lecturer newHead) {
        if (newHead == null) {
            System.out.println("Invalid lecturer provided;");
            return;
        }
        if (!(newHead.getDegree() == Degree.DR || newHead.getDegree() == Degree.Professor)) {
            System.out.println("New chair must have at least a DR or Professor degree; update aborted.");
            return;
        }
        this.headOfComm = newHead;
        removeLecturer(newHead);
        System.out.println("Committee chair updated to: " + newHead.getName());
    
    }

    public void removeLecturer(Lecturer lecturerToRemove) {
        // First pass: count items to keep in this.lecturers
        int count = 0;
        for (Lecturer l : this.lecturers) {
            if (!l.getName().equalsIgnoreCase(lecturerToRemove.getName())) {
                count++;
            }
        }
        // Create a new array sized to hold only the lecturers that are not removed
        Lecturer[] newArr = new Lecturer[count];
        int index = 0;
        for (Lecturer l : this.lecturers) {
            if (!l.getName().equalsIgnoreCase(lecturerToRemove.getName())) {
                newArr[index++] = l;
            }
        }
        // Update the instance field with the new array that excludes lecturerToRemove
        this.lecturers = newArr;
    }
    
    


}
