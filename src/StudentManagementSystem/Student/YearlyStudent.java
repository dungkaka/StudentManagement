package StudentManagementSystem.Student;

import StudentManagementSystem.CourseResult;
import StudentManagementSystem.Semester;
import StudentManagementSystem.SemesterOfStudent;

import java.util.ArrayList;

public class YearlyStudent extends Student{
    ArrayList<SemesterOfStudent> semesterOfStudents = new ArrayList<SemesterOfStudent>();

    public YearlyStudent(String ID, String name, String sex, String birthDay, String department) {
        super(ID, name, sex, birthDay, department);
    }

    public ArrayList<SemesterOfStudent> getSemesterOfStudents() {
        return semesterOfStudents;
    }
    public void setSemesterOfStudents(ArrayList<SemesterOfStudent> semesterOfStudents) {
        this.semesterOfStudents = semesterOfStudents;
    }

    @Override
    public float getCPA() {
        float sum = 0;
        int size = 0;
        for (SemesterOfStudent temp: semesterOfStudents) {
            for (CourseResult temp1 : temp.getCourseResults()) {
                sum += temp1.getResult() * temp1.getSubjectbyIDSubject().getWeightOfSubject();
                size += temp1.getSubjectbyIDSubject().getWeightOfSubject();
            }
        }

        return sum / size;
    }

    @Override
    public void setCPA() {
        this.CPA = this.getCPA();
    }

    public float getGPAOfSemester(String semesterName) {
        float GPA = 0;
        for (SemesterOfStudent temp: semesterOfStudents) {
            if (semesterName.equals(temp.getSemesterName())) {
                GPA = temp.getGPA();
            }
        }
        return GPA;
    }

    @Override
    public CourseResult findCourseResultByNameSubject(String name) {
        for (SemesterOfStudent temp: semesterOfStudents) {
            for (CourseResult temp1 : temp.getCourseResults()) {
                if (temp1.getSubjectbyIDSubject().getName().contains(name)) {
                    return temp1;
                }
            }
        }
        return null;
    }

    @Override
    public CourseResult findCourseResultByIDSubject(String ID) {
        for (SemesterOfStudent temp: semesterOfStudents) {
            for (CourseResult temp1 : temp.getCourseResults()) {
                if (temp1.getSubjectbyIDSubject().getID().contains(ID)) {
                    return temp1;
                }
            }
        }
        return null;
    }

    public boolean checkExistSemesterByIDSemester(String IDSemester) {
        for (SemesterOfStudent temp: semesterOfStudents) {
            if (IDSemester.equals(temp.getIDsemester())) return true;
        }

        return false;
    }

    public String showDetail() {
        String s = "";
        s += "ID: " + this.getID() + "\n";
        s += "Name: " + this.getName() + "\n";
        s += "Gender: " + this.getSex() + "\n";
        s += "Birthday: " + this.getBirthDay() + "\n";
        s += "Age: " + this.getAge() + "\n";
        s += "Department" + this.getDepartment() + "\n";
        s += "Type: " + "Credit Student" + "\n";
        s += "Completed Semester: ";
        for (SemesterOfStudent temp: semesterOfStudents) {
            if(temp.getGPA() >= 5) s+= temp.getIDsemester() + ", ";
        }
        s += "\n";

        return s;
    }

    @Override
    public void showDetailResultStudying() {

        int i = 0;
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("                     " + "ID Student: "  + getID() + "  -  " + "Name: " + getName() );
        System.out.println("*-------------------------------------------------------------------------------------------------------------------*");
        System.out.printf("| %-4s | %-30s | %-8s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "", "Subject", "ID", "Weight", "Middterm", "Final", "Result", "Classify");
        System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
        for (SemesterOfStudent temp0: semesterOfStudents) {
            System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
            for (CourseResult temp : temp0.getCourseResults()) {
                System.out.printf("| %-4s | %-30s | %-8s | %-10d | %-10.1f | %-10.1f | %-10.1f | %-10s |\n", i++, temp.getNameSubject(), temp.getIDSubject(), temp.getSubjectbyIDSubject().getWeightOfSubject(), temp.getMarkOfMiddterm(), temp.getMarkOfFinalTerm(), temp.getResult(), temp.getClassify());
            }
            System.out.printf("| --> %-109s |\n", "Semester Name: " + temp0.getSemesterName() + " - " + "GPA: " + temp0.getGPA() );
        }
        System.out.println("*-------------------------------------------------------------------------------------------------------------------*");

        System.out.println("--> CPA: " + this.getCPA() + "\n");
    }


}
