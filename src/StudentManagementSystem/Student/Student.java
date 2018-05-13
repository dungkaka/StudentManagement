package StudentManagementSystem.Student;
import StudentManagementSystem.CourseResult;
import StudentManagementSystem.Management.*;

import java.util.Calendar;

public abstract class Student {
    private String ID;
    public String name;
    public String sex;
    public String birthDay;
    public String department;
    float CPA;

    public Student(String ID, String name, String sex, String birthDay, String department) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.department = department;
    }

    private void setID(String ID) {
        boolean exist = false;
        for (Student temp: Management.students) {
            if(temp.getID() == ID) exist = true;
        }

        if(exist == false) this.ID = ID;
    }
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        int age = 0;
        int dateBirth = Integer.parseInt(birthDay.substring(0,2));
        int monthBirth = Integer.parseInt(birthDay.substring(3,5));
        int yearBirth = Integer.parseInt(birthDay.substring(6,10));

        Calendar c = Calendar.getInstance();
        int date = c.get(Calendar.DATE);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        if (month > monthBirth ) age = year - yearBirth;
        else if (month == monthBirth) {
            if (date >= dateBirth) age = year - yearBirth;
            else age = year - yearBirth - 1;
        }
        else age = year - yearBirth - 1;

        return age;
    }

    public String getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public abstract void setCPA();
    public abstract float getCPA();

    public abstract CourseResult findCourseResultByIDSubject(String ID);
    public abstract CourseResult findCourseResultByNameSubject(String name);

    public abstract String showDetail();
    public abstract void showDetailResultStudying();

    public CreditStudent toCreditStudent() {
        if (this instanceof CreditStudent) {
            CreditStudent cs = (CreditStudent) this;
            return cs;
        }
        else {
            return null;
        }
    }

    public YearlyStudent toYearlyStudent() {
        if (this instanceof YearlyStudent) {
            YearlyStudent cs = (YearlyStudent) this;
            return cs;
        }
        else {
            return null;
        }
    }



//    public void showInforStudent() {
//        System.out.println("\n----------------------------------------------------------------------------------------------");
//        System.out.printf("| %-10s| %-20s| %-12s| %-20s| %-5s| %-5s| %-6s |\n", "ID", "NAME", "BIRTHDAY", "TYPE OF STUDENT", "AGE", "NCP", "CPA");
//        System.out.println("|-----------|---------------------|-------------|---------------------|------|------|--------|");
//        System.out.printf("| %-10s| %-20s| %-12s| %-20s| %-5s| %-5s| %-6.1f |\n", this.getID(), this.getName(), this.getBirthDay(), this.getTypeOfStudent(), this.getAge(), this.getNumPassCredit(), this.getCPA());
//        System.out.println("----------------------------------------------------------------------------------------------");
//    }
//
//    public void showObjectOfStudent() {
//
//        System.out.println("\n------------------------------------------------------------------------");
//        System.out.printf("| %-68s |\n", "              Student: " + getName().toUpperCase() + " - " + getID());
//        System.out.println("|--------------------------|------|-----------|-----------|------------|");
//        System.out.printf("| %-25s| %-5s| %-10s| %-10s| %-10s |\n", "NAME", "WOF", "POINTMID", "POINTFINAL", "RESULT");
//        System.out.println("|--------------------------|------|-----------|-----------|------------|");
//        for (ObjectStudent temp: objects) {
//            System.out.printf("| %-25s| %-5s| %-10.1f| %-10.1f| %-10.1f |\n", temp.getName(), temp.getWeightOfObject(), temp.getMarkOfMiddterm(), temp.getMarkOfFinalTest(), temp.getResult());
//        }
//        System.out.println("------------------------------------------------------------------------");
//    }
//
//    public String getDegreeClassification(){};
//
//    public void graduation() {
//        if(getDegreeClassification() != null) {
//            Calendar c = Calendar.getInstance();
//            System.out.println("------------------------------------------");
//            System.out.println("|        THE DEGREE OF UNIVERSITY        |");
//            System.out.printf("| %-12s %-25s |\n", "Name: ", getName());
//            System.out.printf("| %-12s %-25s |\n", "Birthday: ", getBirthDay());
//            System.out.printf("| %-25s %-12s |\n", "Degree Classification: ", getDegreeClassification());
//            System.out.printf("| %-25s %-12s |\n", "Year Of Graduation: ", c.get(Calendar.YEAR));
//            System.out.println("------------------------------------------");
//        }
//        else {
//            System.out.println("Student " + getName().toUpperCase() + " is not eligible for graduation new !");
//        }
//    }


}
