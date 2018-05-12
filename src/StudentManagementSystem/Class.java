package StudentManagementSystem;

import StudentManagementSystem.Management.Management;
import StudentManagementSystem.Student.CreditStudent;
import StudentManagementSystem.Student.Student;
import StudentManagementSystem.Student.YearlyStudent;

import java.util.ArrayList;

public class Class {
    private String ID;
    String semesterName;
    String classroom;
    Lecturer lecturer;
    Subject subject;
    String timeStart;
    String timeEnd;

    public Class(String ID, String semesterName, String classroom, Lecturer lecturer, Subject subject, String timeStart, String timeEnd) {
        this.ID = ID;
        this.semesterName = semesterName;
        this.classroom = classroom;
        this.lecturer = lecturer;
        this.subject = subject;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }


    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSemesterName() {
        return semesterName;
    }
    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTimeStart() {
        return timeStart;
    }
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }
    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public ArrayList<Student> getlistStudent() {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Student temp: Management.students) {
            if(temp.findCourseResultByIDSubject(subject.getID()).getIDClass() == ID) {
                students.add(temp);
            }
        }

        return students;
    }

    public String showListSudent() {
        String s = "";
        for (Student temp: Management.students) {
            if(temp.findCourseResultByIDSubject(subject.getID()).getIDClass() == ID) {
                s += temp.getID() + " - ";
                s += temp.getName() + " - ";
                s +=  temp.getSex() + " - ";
                s += temp.getBirthDay() + " - ";
                s += temp.getDepartment() + " - ";
                if(temp instanceof CreditStudent) {
                    s += "Credit Student" + "\n";
                }
                if(temp instanceof YearlyStudent) {
                    s += "Yearly Student" + "\n";
                }
            }
        }

        return s;
    }

    public String showDetail() {

        String s = "";
        s += "ID: " + this.getID() + "\n";
        s += "Name Of Semester: " + this.getSemesterName() + "\n";
        s += "Classroom: " + this.getClassroom() + "\n";
        s += "Lecture: " + this.getLecturer().getName() + "\n";
        s += "Subject: " + this.getSubject().getName() + "\n";
        s += "Time Start: " + this.getTimeStart() + "\n";
        s += "Time End: " + this.getTimeEnd() + "\n\n";

        return s;

    }


}

