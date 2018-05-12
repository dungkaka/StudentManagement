package StudentManagementSystem;

import java.util.ArrayList;

public class Subject {
    String ID;
    String name;
    int weightOfSubject;
    float weightOfMiddterm;
    float weigthOfFinalTest;

    public Subject(String ID, String name, int weightOfSubject, float weightOfMiddterm, float weightOfFinalTest) {
        this.ID = ID;
        this.name = name;
        this.weightOfSubject = weightOfSubject;
        this.weightOfMiddterm = weightOfMiddterm;
        this.weigthOfFinalTest = weightOfFinalTest;
    }

    ArrayList<Subject> preSubject = new ArrayList<Subject>();

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getWeightOfMiddterm() {
        return weightOfMiddterm;
    }
    public void setWeightOfMiddterm(float weightOfMiddterm) {
        this.weightOfMiddterm = weightOfMiddterm;
    }

    public float getWeigthOfFinalTest() {
        return weigthOfFinalTest;
    }
    public void setWeightOfSubject(int weightOfSubject) {
        this.weightOfSubject = weightOfSubject;
    }

    public int getWeightOfSubject() {
        return weightOfSubject;
    }
    public void setWeigthOfFinalTest(float weigthOfFinalTest) {
        this.weigthOfFinalTest = weigthOfFinalTest;
    }

    public ArrayList<Subject> getPreSubject() {
        return preSubject;
    }
    public void setPreSubject(ArrayList<Subject> preSubject) {
        this.preSubject = preSubject;
    }
    public void addPreSubject(Subject subject) {
        preSubject.add(subject);
    }

    public boolean isPreSubject(Subject subject) {
        return subject.getPreSubject().contains(this);
    }

    public String showListPreSubject() {
        String s = "";
        for (Subject temp: preSubject) {
            s += temp.getName() + ", ";
        }
        return s;
    }

    public String showDetail() {
        String s = "";
        s += "ID: " + this.getID() + "\n";
        s += "Name: " + this.getName() + "\n";
        s += "Weight Of Middterm: " + this.getWeightOfMiddterm() + "\n";
        s += "Weight Of Final: " + this.getWeigthOfFinalTest() + "\n\n";

        return s;
    }

}
