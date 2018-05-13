package StudentManagementSystem.Management;

import StudentManagementSystem.Student.CreditStudent;
import StudentManagementSystem.Student.Student;
import StudentManagementSystem.Student.YearlyStudent;

public class StudentManagement {

    public void addStudent(Student student) {
        Management.students.add(student);
    }

    public void removeStudent(Student student) {
        Management.students.remove(student);
    }

    public String inforOfStudent(Student student) {

        return
                "---------------------------------------------\n"
                + student.showDetail()
                + "---------------------------------------------\n";
    }

    public void showListInforStudent() {
        System.out.println("\n*--------------------------------------------------------------------------------------------------*");
        System.out.printf("| %-12s| %-30s| %-7s| %-12s| %-5s| %-20s |\n", "ID", "NAME", "GENDER", "BIRTHDAY", "AGE", "DEPARTMENT");
        System.out.println("|-------------|-------------------------------|--------|-------------|------|----------------------|");
        for (Student temp : Management.students) {
            System.out.printf("| %-12s| %-30s| %-7s| %-12s| %-5s| %-20s |\n", temp.getID(), temp.getName(), temp.getSex(), temp.getBirthDay(), temp.getAge(), temp.getDepartment());
        }

        System.out.println("*--------------------------------------------------------------------------------------------------*");

    }


}
