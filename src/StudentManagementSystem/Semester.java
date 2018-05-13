package StudentManagementSystem;

import java.util.ArrayList;

public class Semester {
    private String ID;
    String department;

    public ArrayList<Subject> subjects = new ArrayList<Subject>();

    public Semester(String ID, String department, ArrayList<Subject> subjects) {
        this.ID = ID;
        this.department = department;
        this.subjects = subjects;
    }

    public String getID() {
        return ID;
    }
    public void setID(String name) {
        this.ID = name;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public Subject findSubjectByID(String ID) {
        for (Subject temp: subjects) {
            if (ID.equals(temp.getID())) {
                return temp;
            }
        }

        return null;
    }
    public Subject findSubjectByName(String name) {
        for (Subject temp: subjects) {
            if (name.equals(temp.getName())) {
                return temp;
            }
        }
        return null;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public String showDetail() {
        String s = "";
        s += "ID: " + getID() + "\n";
        s += "Department: " + getDepartment() + "\n";
        s += "Subjects: ";
        for (Subject temp: subjects) {
            s += temp.getName() + ", ";
        }
        s += "\n";

        return s;
    }

}
