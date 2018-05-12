package StudentManagementSystem.Management;

import StudentManagementSystem.Class;
import StudentManagementSystem.SemesterOfStudent;
import StudentManagementSystem.Student.CreditStudent;
import StudentManagementSystem.Student.Student;
import StudentManagementSystem.Student.YearlyStudent;

public class StudentRegister {

    public void registerForCreditStudent(Student student, Class aClass) {
        CreditStudent cs = (CreditStudent) student;
        cs.registerClass(aClass);
    }

    public void registerForYearlyStudent(Student student, SemesterOfStudent semesterOfStudent) {
        YearlyStudent ys = (YearlyStudent) student;
        ys.getSemesterOfStudents().add(semesterOfStudent);

    }

    public String showListOfClass() {
        String s = "";
        for(Class temp: Management.classes) {
            s += temp.showDetail();
        }
        return s;
    }
}
