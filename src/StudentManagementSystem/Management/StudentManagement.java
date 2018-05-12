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
        return student.showDetail();
    }

    public String showListInforStudent() {
        String s = "";
        for (Student temp: Management.students) {
            s += temp.showDetail();
        }

        return s;
    }

}
