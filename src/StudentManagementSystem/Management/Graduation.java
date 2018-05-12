package StudentManagementSystem.Management;

import StudentManagementSystem.Student.CreditStudent;
import StudentManagementSystem.Student.Student;
import StudentManagementSystem.Student.YearlyStudent;

public class Graduation {

    public String getDegreeClassification(Student student) {
        String degreeClassification = null;

        if (student instanceof CreditStudent) {
            CreditStudent cs = (CreditStudent) student;
            if (cs.getAccumulatedCredit() > 80){
                if (cs.getCPA() >= 8) degreeClassification = "Very Good !";
                else if (cs.getCPA() >= 7) degreeClassification = "Good !";
                else if (cs.getCPA() >= 6) degreeClassification = "Average Good !";
                else if (cs.getCPA() >= 5) degreeClassification = "Average !";
            }
            else degreeClassification = "Do Not Graduation";
        }

        if (student instanceof YearlyStudent) {
            YearlyStudent cs = (YearlyStudent) student;
            if (cs.getSemesterOfStudents().size() == 10){
                if (cs.getCPA() >= 8) degreeClassification = "Very Good !";
                else if (cs.getCPA() >= 7) degreeClassification = "Good !";
                else if (cs.getCPA() >= 6) degreeClassification = "Average Good !";
                else if (cs.getCPA() >= 5) degreeClassification = "Average !";
            }
        }


        return degreeClassification;

    }

    public void graduation(Student student) {

    }
}
