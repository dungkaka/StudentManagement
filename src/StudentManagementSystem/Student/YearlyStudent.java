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
                sum += temp1.getResult() * temp1.getClassByID().getSubject().getWeightOfSubject();
                size += temp1.getClassByID().getSubject().getWeightOfSubject();
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
                if (temp1.getClassByID().getSubject().getName().contains(name)) {
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
                if (temp1.getClassByID().getSubject().getID().contains(ID)) {
                    return temp1;
                }
            }
        }
        return null;
    }

    public String showDetail() {
        String s = "";
        s += "ID: " + this.getID() + "\n";
        s += "Name: " + this.getName() + "\n";
        s += "Sex: " + this.getSex() + "\n";
        s += "Birthday: " + this.getBirthDay() + "\n";
        s += "Age: " + this.getAge() + "\n";
        s += "Department" + this.getDepartment() + "\n";
        s += "Type: " + "Credit Student" + "\n";

        return s;
    }

    @Override
    public String showDetailResultStudying() {
        String s = "";

        for (SemesterOfStudent temp: semesterOfStudents) {
            s += temp.getSemesterName() + ": \n";
            for (CourseResult temp1: temp.getCourseResults()) {
                s += temp1.getNameSubject() + " - ";
                s += "Middterm: " + temp1.getMarkOfMiddterm() + " - ";
                s += "Final: " + temp1.getMarkOfFinalTerm() + " - ";
                s += "Result: " + temp1.getResult() + " - ";
                s += "Classify: " + temp1.getClassify() + "\n";
            }
            s += "--> GPA: " + temp.getGPA() + "\n";
        }

        s += "---------------------------\n";
        s += "CPA: " + this.getCPA() + "\n\n";

        return s;
    }

}
