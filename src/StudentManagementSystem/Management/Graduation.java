package StudentManagementSystem.Management;

import StudentManagementSystem.SemesterOfStudent;
import StudentManagementSystem.Student.CreditStudent;
import StudentManagementSystem.Student.Student;
import StudentManagementSystem.Student.YearlyStudent;

public class Graduation {

    public String getDegreeClassification(Student student) {
        String degreeClassification = null;

        if (student instanceof CreditStudent) {
            CreditStudent cs = (CreditStudent) student;
            if (cs.getAccumulatedCredit() >= 150){
                if (cs.getCPA() >= 8) degreeClassification = "Very Good !";
                else if (cs.getCPA() >= 7) degreeClassification = "Good !";
                else if (cs.getCPA() >= 6) degreeClassification = "Average Good !";
                else if (cs.getCPA() >= 5) degreeClassification = "Average !";
            }
            else degreeClassification = "";
        }

        if (student instanceof YearlyStudent) {
            YearlyStudent cs = (YearlyStudent) student;
            if (cs.getSemesterOfStudents().size() == 10){
                if (cs.getCPA() >= 8) degreeClassification = "Very Good !";
                else if (cs.getCPA() >= 7) degreeClassification = "Good !";
                else if (cs.getCPA() >= 6) degreeClassification = "Average Good !";
                else if (cs.getCPA() >= 5) degreeClassification = "Average !";
            }

            else degreeClassification = "";
        }


        return degreeClassification;

    }

    public void graduation(Student student) {
        if (student instanceof CreditStudent) {
            CreditStudent cs = (CreditStudent) student;
            System.out.println("-----------------------");
            System.out.println("ID: " + student.getID());
            System.out.println("Name: " + student.getName());
            System.out.println("Type: " + "Credit Student");
            System.out.println("CPA: " + student.getCPA());
            System.out.println("Accumulated Credit/Subject: " + cs.getAccumulatedCredit() + "/" + cs.getAccumulatedSubject());
            System.out.println("Number Of Debt Credit/Subject: " + cs.getNumberOfDebtCredit() + "/" + cs.getNumberOfDebtSubject());
            System.out.println("Number Of Register Credit: " + cs.getNumberOfRegisterCredit());

            String s = getDegreeClassification(cs);
            if(s.equals("")) {
                System.out.println("Credit Student must be completed at least 150 credit and CPA >= 5 to graduated");
                return;
            }

            else {
                System.out.println("CLASSIFICATION: " + getDegreeClassification(cs));
            }
        }

        if (student instanceof YearlyStudent) {
            YearlyStudent ys = (YearlyStudent) student;
            System.out.println("-----------------------");
            System.out.println("ID: " + student.getID());
            System.out.println("Name: " + student.getName());
            System.out.println("Type: " + "Credit Student");
            System.out.println("CPA: " + student.getCPA());
            System.out.println("Completed Semester: ");
            for (SemesterOfStudent temp: ys.getSemesterOfStudents()) {
                if(temp.getGPA() >= 5) System.out.println(temp.getIDsemester() + ", ");
            }

            String s = getDegreeClassification(ys);
            if(s.equals("")) {
                System.out.println("Yearly Student must be completed all 10 semester and CPA >= to graduated");
                return;
            }

            else {
                System.out.println("CLASSIFICATION: " + getDegreeClassification(ys));
            }
        }
    }

}
