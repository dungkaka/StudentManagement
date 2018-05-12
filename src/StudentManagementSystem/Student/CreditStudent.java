package StudentManagementSystem.Student;

import StudentManagementSystem.Class;
import StudentManagementSystem.CourseResult;
import StudentManagementSystem.Management.Management;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CreditStudent extends Student {
    int accumulatedCredit;
    int accumulatedSubject;
    int numberOfDebtCredit;
    int numberOfDebtSubject;
    int numberOfRegisterCredit;


    ArrayList<CourseResult> courseResults = new ArrayList<CourseResult>();

    public CreditStudent(String ID, String name, String sex, String birthDay, String department) {
        super(ID, name, sex, birthDay, department);
    }

    public int getAccumulatedCredit() {
        int size = 0;
        for (CourseResult temp: courseResults) {
            if (temp.getResult() >= 4) size += temp.getClassByID().getSubject().getWeightOfSubject();
        }
        return size;
    }
    public void setAccumulatedCredit() {
        this.accumulatedCredit = this.getAccumulatedSubject();
    }

    public int getAccumulatedSubject() {
        int size = 0;
        for (CourseResult temp: courseResults) {
            if (temp.getResult() >= 4) size++;
        }

        return size;
    }
    public void setAccumulatedSubject() {
        this.accumulatedSubject = this.getAccumulatedSubject();
    }

    public int getNumberOfDebtCredit() {
        int size = 0;
        for (CourseResult temp: courseResults) {
            if (temp.getResult() < 4 && temp.getClassify() != "") size += temp.getClassByID().getSubject().getWeightOfSubject();
        }
        return size;
    }
    public void setNumberOfDebCredit() {
        this.numberOfDebtCredit = this.getNumberOfDebtCredit();
    }

    public int getNumberOfDebtSubject() {
        int size = 0;
        for (CourseResult temp: courseResults) {
            if (temp.getResult() < 4 && temp.getClassify() != "") size++;
        }
        return size;
    }
    public void setNumberOfDebtSubject() {
        this.numberOfDebtSubject = this.getAccumulatedSubject();
    }

    public int getNumberOfRegisterCredit() {
        int size = 0;
        for (CourseResult temp: courseResults) {
            if (temp.getClassify() != "") size += temp.getClassByID().getSubject().getWeightOfSubject();
        }
        return size;
    }

    public void setNumberOfRegisterCredit() {
        this.numberOfRegisterCredit = this.numberOfRegisterCredit;
    }

    public ArrayList<CourseResult> getCourseResults() {
        return courseResults;
    }
    public void setCourseResults(ArrayList<CourseResult> courseResults) {
        this.courseResults = courseResults;
    }

    @Override
    public float getCPA() {
        float sum = 0;
        int size = 0;
        for (CourseResult temp: courseResults) {
            sum += temp.getResult() * temp.getClassByID().getSubject().getWeightOfSubject();
            size += temp.getClassByID().getSubject().getWeightOfSubject();
        }

        return sum / size;
    }

    @Override
    public void setCPA() {
        this.CPA = this.getCPA();
    }

    public void getGPAOfSemester(String semesterName) {
        float sum = 0;
        int size = 0;

        for(CourseResult temp: courseResults) {
            if (semesterName.equals(temp.getClassByID().getSemesterName())) {
                sum += temp.getResult() * temp.getClassByID().getSubject().getWeightOfSubject();
                size += temp.getClassByID().getSubject().getWeightOfSubject();
            }
        }

    }

    public ArrayList<Class> listClass() {
        return Management.classes;
    }

    public boolean canRegisterClass(Class aClass) {
        int exist = 0;
        int size = 0;

        for (CourseResult temp: courseResults) {
            if(temp.getClassByID().getSubject().isPreSubject(aClass.getSubject())) {
                size ++;
            }
        }

        if (size == aClass.getSubject().getPreSubject().size()) return true;

        return false;
    }

    public void registerClass(Class aClass) {
        courseResults.add(new CourseResult(aClass.getID()));
    }

    public CourseResult findCourseResultByNameSubject(String name) {
        for (CourseResult temp: courseResults) {
            if (temp.getClassByID().getSubject().getName().contains(name)) {
                return temp;
            }
        }
        return null;
    }

    public CourseResult findCourseResultByIDSubject(String ID) {
        for (CourseResult temp: courseResults) {
            if (temp.getClassByID().getSubject().getID().contains(ID)) {
                return temp;
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
        s += "Department: " + this.getDepartment() + "\n";
        s += "Type: " + "Credit Student" + "\n\n";

        return s;

    }

    @Override
    public String showDetailResultStudying() {
        String s = "";
        for (CourseResult temp: courseResults) {
            s += temp.getNameSubject() + " - ";
            s += "Middterm: " + temp.getMarkOfMiddterm() + " - ";
            s += "Final: " + temp.getMarkOfFinalTerm() + " - ";
            s += "Result: " + temp.getResult() + " - ";
            s += "Classify: " + temp.getClassify() + "\n";
        }

        s += "---------------------------\n";
        s += "CPA: " + this.getCPA() + "\n";
        s += "Accumulated Credit/Subject: " + getAccumulatedCredit() + "/" + getAccumulatedSubject() + "\n";
        s += "Number Of Debt Credit/Subject: " + getNumberOfDebtCredit() + "/" + getNumberOfDebtSubject() + "\n";
        s += "Number Of Register Credit: " + getNumberOfRegisterCredit() + "\n\n";
        return s;
    }


}
