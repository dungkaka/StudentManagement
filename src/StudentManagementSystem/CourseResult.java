package StudentManagementSystem;

import StudentManagementSystem.Management.Management;

public class CourseResult {
    private String IDClass;
    private String nameSubject;
    float markOfMiddterm;
    float markOfFinalTerm;
    float result;
    String classify = "";


    public CourseResult() {}

    public CourseResult(String IDClass) {
        this.IDClass = IDClass;
    }

    public CourseResult(String IDClass, float markOfMiddterm, float markOfFinalTerm) {
        this.IDClass = IDClass;
        this.nameSubject = getClassByID().getSubject().getName();
        this.markOfMiddterm = markOfMiddterm;
        this.markOfFinalTerm = markOfFinalTerm;
        this.result = getResult();
        this.classify = getClassify();
    }

    public String getIDClass() {
        return IDClass;
    }
    public void setIDClass(String IDClass) {
        this.IDClass = IDClass;
    }

    public String getNameSubject() {
        return nameSubject;
    }
    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public float getMarkOfFinalTerm() {
        return markOfFinalTerm;
    }
    public void setMarkOfFinalTerm(float markOfFinalTerm) {
        this.markOfFinalTerm = markOfFinalTerm;
    }

    public float getMarkOfMiddterm() {
        return markOfMiddterm;
    }
    public void setMarkOfMiddterm(float markOfMiddterm) {
        this.markOfMiddterm = markOfMiddterm;
    }

    public Class getClassByID() {
        for (Class temp: Management.classes) {
            if (this.getIDClass().equals(temp.getID())) {
                return temp;
            }
        }
        return null;
    }

    public float getResult() {
        return markOfMiddterm * this.getClassByID().getSubject().getWeightOfMiddterm() + markOfFinalTerm * this.getClassByID().getSubject().getWeigthOfFinalTest();
    }
    public void setResult() {
        this.result = this.getResult();
    }

    public String getClassify() {
        if (getResult() >= 8.5) return "A";
        else if(getResult() >= 8) return "B+";
        else if(getResult() >= 7) return "B";
        else if(getResult() >= 6.5) return "C+";
        else if(getResult() >= 5.5) return "C";
        else if(getResult() >= 4.5) return "D+";
        else if(getResult() >= 4) return "D";
        else if(getResult() > 0) return "F";
        else return "";
    }
    public void setClassify() {
        this.classify = this.getClassify();
    }

    public Subject getSubject() {
        return this.getClassByID().getSubject();
    }

}
