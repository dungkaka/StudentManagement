package StudentManagementSystem;

import StudentManagementSystem.Management.Management;

import java.util.ArrayList;

public class SemesterOfStudent {
    String semesterName;
    String IDsemester;
    String classroom;
    String timeStart;
    String timeEnd;
    float GPA;

    ArrayList<CourseResult> courseResults = new ArrayList<CourseResult>();

    public SemesterOfStudent() {

    }

    public SemesterOfStudent(String semesterName, String IDsemester, String classroom, String timeStart, String timeEnd) {
        this.semesterName = semesterName;
        this.IDsemester = IDsemester;
        this.classroom = classroom;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;

        Semester semester = getSemesterByID();
        for(Subject temp: semester.subjects) {
            CourseResult courseResult = new CourseResult();
            courseResult.setIDSubject(temp.getID());
            courseResult.setNameSubjectByIDSubject();
            courseResult.setIDClass(semesterName);
            courseResults.add(courseResult);
        }

    }

    public String getSemesterName() {
        return semesterName;
    }
    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
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

    public String getIDsemester() {
        return IDsemester;
    }
    public void setIDsemester(String IDsemester) {
        this.IDsemester = IDsemester;
    }

    public ArrayList<CourseResult> getCourseResults() {
        return courseResults;
    }
    public void setCourseResults() {
        Semester semester = getSemesterByID();
        for(Subject temp: semester.subjects) {
            CourseResult courseResult = new CourseResult();
            courseResult.setNameSubjectByIDSubject();
            courseResult.setIDClass(semesterName);
            courseResult.setResult();
            courseResult.setClassify();
            courseResults.add(courseResult);
        }
    }

    public float getGPA() {
        return GPA;
    }
    public void setGPA() {
        float sum = 0;
        int size = 0;
        for (CourseResult temp: courseResults) {
            sum += temp.getResult() * temp.getSubjectbyIDSubject().getWeightOfSubject();
            size += temp.getSubjectbyIDSubject().getWeightOfSubject();
        }

        this.GPA = sum / size;
    }

    public CourseResult findCourseByIDSubject(String IDSubject)  {
        for (CourseResult temp : courseResults) {
            if (temp.getClassByID().getSubject().getID().contains(IDSubject)) {
                return temp;
            }
        }
        return null;

    }

    public Semester getSemesterByID() {
        for (Semester temp: Management.semesters) {
            if (IDsemester.equals(temp.getID())) return temp;
        }

        return null;
    }

    public String showDetail() {
        String s = "";
        s += "Name Of Semester: " + this.getSemesterName() + "\n";
        s += "ID Of Semester: " + this.getIDsemester() + "\n";
        s += "Classroom: " + this.getClassroom() + "\n";
        s += "Time Start: " + this.getTimeStart() + "\n";
        s += "Time End: " + this.getTimeEnd() + "\n\n";

        return s;
    }

}
