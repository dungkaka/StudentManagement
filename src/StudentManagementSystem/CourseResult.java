package StudentManagementSystem;

import StudentManagementSystem.Management.Management;

public class CourseResult {
    private String IDClass;
    private String IDSubject;
    private String nameSubject;
    float markOfMiddterm;
    float markOfFinalTerm;
    float result;
    String classify = "";


    public CourseResult() {
//        this.setNameSubject();
//        this.setResult();
    }

    public CourseResult(String IDClass) {
        this.IDClass = IDClass;
        this.setIDSubject();
        this.setNameSubject();
        this.setResult();
        this.setClassify();
    }


    public CourseResult(String IDClass, float markOfMiddterm, float markOfFinalTerm) {
        this.IDClass = IDClass;
        this.nameSubject = getClassByID().getSubject().getName();
        this.markOfMiddterm = markOfMiddterm;
        this.markOfFinalTerm = markOfFinalTerm;
        this.setResult();
        this.setClassify();
    }

    public String takeNameSubject() {
        return this.nameSubject;
    }

    public String getIDClass() {
        return IDClass;
    }
    public void setIDClass(String IDClass) {
        this.IDClass = IDClass;
    }

    public String getNameSubject() {
        return this.getSubjectbyIDSubject().getName();
    }
    public void setNameSubject() {
        this.nameSubject = this.getNameSubject();
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

    public String getIDSubject() {
        return this.IDSubject;
    }

    public void setIDSubject() {
        this.IDSubject = this.getClassByID().getSubject().getID();
    }

    public void setIDSubject(String IDSubject) {
        this.IDSubject = IDSubject;
    }


    public Subject getSubjectbyIDSubject() {
        for(Subject temp: Management.subjects) {
            if(this.IDSubject.equals(temp.getID()))
                return temp;
        }
        return null;
    }

    public void setNameSubjectByIDSubject() {
        this.nameSubject = this.getSubjectbyIDSubject().getName();
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
        return markOfMiddterm * this.getSubjectbyIDSubject().getWeightOfMiddterm() + markOfFinalTerm * this.getSubjectbyIDSubject().getWeigthOfFinalTest();
    }
    public void setResult() {
        this.result = this.getResult();
    }

    public String getClassify() {
        if (getResult() >= 8.5) return "A";
        else if(getResult() >= 8) return "B+";
        else if(getResult() >= 7) return "B";
        else if(getResult() >= 6.5) return "C+";
        else if(getResult() >= 5.5 && getMarkOfFinalTerm() > 3) return "C";
        else if(getResult() >= 4.5  && getMarkOfFinalTerm() > 3) return "D+";
        else if(getResult() >= 4 && getMarkOfFinalTerm() > 3) return "D";
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
