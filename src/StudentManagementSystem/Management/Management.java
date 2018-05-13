package StudentManagementSystem.Management;

import StudentManagementSystem.*;
import StudentManagementSystem.Class;
import StudentManagementSystem.Student.CreditStudent;
import StudentManagementSystem.Student.Student;
import StudentManagementSystem.Student.YearlyStudent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.Year;
import java.util.ArrayList;
import java.util.PropertyPermission;
import java.util.Scanner;

public class Management {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
    public static ArrayList<Subject> subjects = new ArrayList<Subject>();
    public static ArrayList<Class> classes = new ArrayList<Class>();
    public static ArrayList<Semester> semesters = new ArrayList<Semester>();
    public static ArrayList<SemesterOfStudent> semesterOfStudents = new ArrayList<SemesterOfStudent>();


    public static void initialize() {

        Gson gson = new Gson();


        try (Reader reader = new FileReader("Subjects.json")) {

            ArrayList<Subject> subjects = new ArrayList<Subject>();

            subjects = gson.fromJson(reader, new TypeToken<ArrayList<Subject>>() {
            }.getType());

            for (Subject temp : subjects) {
                Management.subjects.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = new FileReader("Lecturers.json")) {

            ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();

            lecturers = gson.fromJson(reader, new TypeToken<ArrayList<Lecturer>>() {
            }.getType());

            for (Lecturer temp : lecturers) {
                Management.lecturers.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (Reader reader = new FileReader("Classes.json")) {

            ArrayList<Class> classes = new ArrayList<Class>();

            classes = gson.fromJson(reader, new TypeToken<ArrayList<Class>>() {
            }.getType());

            for (Class temp: classes) {
                Management.classes.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = new FileReader("Semesters.json")) {

            ArrayList<Semester> semesters = new ArrayList<Semester>();

            semesters = gson.fromJson(reader, new TypeToken<ArrayList<Semester>>() {
            }.getType());

            for (Semester temp : semesters) {
                Management.semesters.add(temp);
            }

        } catch (IOException e) {

        }

        try (Reader reader = new FileReader("SemesterOfStudents.json")) {

            ArrayList<SemesterOfStudent> semesterOfStudents = new ArrayList<SemesterOfStudent>();

            semesterOfStudents = gson.fromJson(reader, new TypeToken<ArrayList<SemesterOfStudent>>() {
            }.getType());

            for (SemesterOfStudent temp : semesterOfStudents) {
                Management.semesterOfStudents.add(temp);
            }

        } catch (IOException e) {

        }

        try (Reader reader = new FileReader("CreditStudents.json")) {

            ArrayList<CreditStudent> creditStudents = new ArrayList<CreditStudent>();

            creditStudents = gson.fromJson(reader, new TypeToken<ArrayList<CreditStudent>>() {
            }.getType());

            for (CreditStudent temp : creditStudents) {
                for (CourseResult temp1: temp.getCourseResults()) {
                    temp1.setIDSubject();
                    temp1.setNameSubject();
                    temp1.setResult();
                    temp1.setClassify();
                }
                students.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = new FileReader("YearlyStudents.json")) {

            ArrayList<YearlyStudent> yearlyStudents = new ArrayList<YearlyStudent>();

            yearlyStudents = gson.fromJson(reader, new TypeToken<ArrayList<YearlyStudent>>() {
            }.getType());

            for (YearlyStudent temp : yearlyStudents) {
                for(SemesterOfStudent temp1: temp.getSemesterOfStudents()) {
                    for(CourseResult temp2: temp1.getCourseResults()) {
                        temp2.setNameSubjectByIDSubject();
                        temp2.setIDClass(temp1.getSemesterName());
                        temp2.setResult();
                        temp2.setClassify();
                    }
                    temp1.setGPA();
                }
                students.add(temp);
            }

        } catch (IOException e) {

        }




    }
    public static void writeToFile() {
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter("CreditStudents.json")) {
            ArrayList<CreditStudent> creditStudents = new ArrayList<CreditStudent>();
            for (Student temp: students) {
                if(temp instanceof CreditStudent) {
                    creditStudents.add((CreditStudent) temp);
                }
            }
            gson.toJson(creditStudents, writer);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("YearlyStudents.json")) {
            ArrayList<YearlyStudent> yearlyStudents = new ArrayList<YearlyStudent>();
            for (Student temp: students) {
                if(temp instanceof YearlyStudent) {
                    yearlyStudents.add((YearlyStudent) temp);
                }
            }
            gson.toJson(yearlyStudents, writer);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("Subjects.json")) {
            gson.toJson(subjects, writer);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("Lecturers.json")) {
            gson.toJson(lecturers, writer);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("Classes.json")) {
            gson.toJson(classes, writer);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("Semesters.json")) {
            gson.toJson(semesters, writer);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("SemesterOfStudents.json")) {
            gson.toJson(semesterOfStudents, writer);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static Student findStudentByID(String ID) {
        for (Student temp: students) {
            if (ID.equals(temp.getID())) {
                return temp;
            }
        }
        return null;
    }
    public static Lecturer findLecturerByID(String ID) {
        for (Lecturer temp: lecturers) {
            if(ID.equals(temp.getID())) {
                return temp;
            }
        }
        return null;
    }
    public static Subject findSubjectByID(String ID) {
        for (Subject temp: subjects) {
            if(ID.equals(temp.getID())) {
                return temp;
            }
        }
        return null;
    }
    public static Class findClassByID(String ID) {
        for (Class temp: classes) {
            if(ID.equals(temp.getID())) {
                return temp;
            }
        }
        return null;
    }
    public static Semester findSemesterByID(String ID) {
        for (Semester temp: semesters) {
            if(ID.equals(temp.getID())) {
                return temp;
            }
        }
        return null;
    }
    public static SemesterOfStudent findSemesterOfStudentByNameAndID(String semesterName, String IDSemester) {
        for (SemesterOfStudent temp: semesterOfStudents) {
            if(semesterName.equals(temp.getSemesterName()) && IDSemester.equals(temp.getIDsemester())) {
                return temp;
            }
        }
        return null;
    }

    public static void showListSubject() {
        System.out.println("*---------------------------------------------------------------------------------------------------*");
        System.out.printf("| %-10s | %-30s | %-10s | %-10s | %-10s | %-10s |\n", "ID", "Name", "Weight", "W Middterm", "W Final", "Prerequisite");
        System.out.println("|------------|--------------------------------|------------|------------|------------|--------------|");
        for (Subject temp : subjects) {
            System.out.printf("| %-10s | %-30s | %-10d | %-10.1f | %-10.1f | %-12s |\n", temp.getID(), temp.getName(), temp.getWeightOfSubject(), temp.getWeightOfMiddterm(), temp.getWeigthOfFinalTest(), temp.showListIDPreSubject());
        }
        System.out.println("*---------------------------------------------------------------------------------------------------*");
        System.out.println("");

    }

    public static void showListLecture() {
        System.out.println("*------------------------------------------------------------------------------------------------------------------------------------*");
        System.out.printf("| %-8s | %-25s | %-8s | %-12s | %-14s | %-15s | %-30s |\n", "ID", "Name", "Gender", "Birthday", "Phone Number", "Department", "Address");
        System.out.println("|----------|---------------------------|----------|--------------|----------------|-----------------|--------------------------------|");
        for (Lecturer temp: lecturers) {
            System.out.printf("| %-8s | %-25s | %-8s | %-12s | %-14s | %-15s | %-30s |\n", temp.getID(), temp.getName(), temp.getSex(), temp.getBirthDay(), temp.getPhoneNumber(), temp.getDepartment(), temp.getAddress());
        }
        System.out.println("*------------------------------------------------------------------------------------------------------------------------------------*");
        System.out.println("");
    }

    public static void showListClass() {
        System.out.println("*-------------------------------------------------------------------------------------------------------------------------*");
        System.out.printf("| %-8s | %-10s |%-8s | %-25s | %-30s | %-10s | %-10s |\n", "ID", "Semester", "Classroom", "Lecturer", "Subject", "Time Start", "Time End");
        System.out.println("|----------|------------|----------|---------------------------|--------------------------------|------------|------------|");
        for(Class temp: classes) {
            System.out.printf("| %-8s | %-10s | %-8s | %-25s | %-30s | %-10s | %-10s |\n", temp.getID(), temp.getSemesterName(), temp.getClassroom(), temp.getLecturer().getName(), temp.getSubject().getName(), temp.getTimeStart(), temp.getTimeEnd());
        }
        System.out.println("*-------------------------------------------------------------------------------------------------------------------------*");
    }

    public static void showListSemester() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        for (Semester temp: semesters) {
            System.out.print(temp.showDetail());
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }
    }

    public static void showListSemesterForStudent() {
        System.out.println("*----------------------------------------------------------------------*");
        System.out.printf("| %-15s | %-11s | %-10s | %-10s | %-10s |\n", "Semester Name", "Semester ID", "Classroom", "Time Start", "Time End");
        System.out.println("|-----------------|-------------|------------|------------|------------|");
        for (SemesterOfStudent temp: semesterOfStudents) {
            System.out.printf("| %-15s | %-11s | %-10s | %-10s | %-10s |\n", temp.getSemesterName(), temp.getIDsemester(), temp.getClassroom(), temp.getTimeStart(), temp.getTimeEnd());
        }
        System.out.println("*----------------------------------------------------------------------*");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String selection = "0";
        String IDStudent, studentName, studentSex, studentBirthday, studentDepartment;
        String IDSubject;
        float markOfMiddterm, markOfFinal;
        String IDClass, IDLecture;
        String semesterName, IDSemester;
        Student student;
        CourseResult courseResult;
        StudentManagement sm = new StudentManagement();
        StudentRegister sr = new StudentRegister();
        GradingForCourse gfc = new GradingForCourse();
        Graduation gra = new Graduation();

        initialize();

        do {
            System.out.println("STUDENT MANAGEMENT");
            System.out.println("---------------------------------");
            System.out.println("1. Student Management");
            System.out.println("2. Student Register");
            System.out.println("3. Grading Management");
            System.out.println("4. Graduation Management");
            System.out.println("5. Class, Subject, Lecture Management");
            System.out.println("6. Exit");
            System.out.print("Your selection: ");
            selection = input.nextLine();

            switch (selection) {
                case "1": //Student Management
                    do {
                        System.out.println("STUDENT MANAGEMENT");
                        System.out.println("---------------------------------");
                        System.out.println("1. Show List Of Student");      //**
                        System.out.println("2. Add New Credit Student");
                        System.out.println("3. Add New Yearly Student");
                        System.out.println("4. Remove Student");
                        System.out.println("5. Search Student By ID");
                        System.out.println("6. Back");
                        System.out.print("Your selection: ");
                        selection = input.nextLine();

                        if(selection.equals("6")) break;

                        switch (selection) {
                            case "1":
                                sm.showListInforStudent();
                                break;

                            case "2": // Add New Credit Student
                                System.out.println("ID: ");
                                IDStudent = input.nextLine();
                                student = findStudentByID(IDStudent);
                                if(student != null) {
                                    System.out.println("This student ID " + IDStudent + " was exist !");
                                    break;
                                }

                                System.out.println("Name: ");
                                studentName = input.nextLine();
                                System.out.println("Sex: ");
                                studentSex = input.nextLine();
                                System.out.println("Birth Day: ");
                                studentBirthday = input.nextLine();
                                System.out.println("Department: ");
                                studentDepartment = input.nextLine();


                                sm.addStudent(new CreditStudent(IDStudent, studentName, studentSex, studentBirthday, studentDepartment));
                                System.out.println("Adding new student is SUCCESSFUL !!!");
                                break;

                            case "3": // Add New Yearly Student
                                System.out.println("ID: ");
                                IDStudent = input.nextLine();
                                student = findStudentByID(IDStudent);
                                if(student != null) {
                                    System.out.println("This student ID " + IDStudent + " was exist !");
                                    break;
                                }

                                System.out.println("Name: ");
                                studentName = input.nextLine();
                                System.out.println("Sex: ");
                                studentSex = input.nextLine();
                                System.out.println("Birth Day: ");
                                studentBirthday = input.nextLine();
                                System.out.println("Department: ");
                                studentDepartment = input.nextLine();

                                sm.addStudent(new YearlyStudent(IDStudent, studentName, studentSex, studentBirthday, studentDepartment));
                                System.out.println("Adding new student is SUCCESSFUL !!!");
                                break;


                            case "4":  // Remove Student
                                System.out.println("ID: ");
                                IDStudent = input.nextLine();
                                student = findStudentByID(IDStudent);
                                if(student == null) {
                                    System.out.println("This student ID " + IDStudent + " is not exist !");
                                    break;
                                }

                                sm.removeStudent(student);
                                System.out.println("Removing student is SUCCESSFUL !!!");


                                break;

                            case "5": // Search Student By ID
                                System.out.println("ID Of Student: ");
                                IDStudent = input.nextLine();
                                student = findStudentByID(IDStudent);

                                if(student == null) {
                                    System.out.println("There is not exist student ID " + IDStudent);
                                    break;
                                }

                                System.out.println(sm.inforOfStudent(student));

                                break;

                            case "6":
                                break;
                            default:
                                System.out.println("Please enter \"1 - 6\" \n");
                        }

                    } while (selection != "6");
                    break;

                case "2": // Student Register
                    do {
                        System.out.println("STUDENT REGISTER");
                        System.out.println("---------------------------------");
                        System.out.println("1. Register Class For Credit Student");
                        System.out.println("2. Register Semester For Yearly Student");
                        System.out.println("3. List Of Class (For Credit Student)"); //**
                        System.out.println("4. Back");
                        System.out.print("Your selection: ");
                        selection = input.nextLine();

                        if(selection.equals("4")) break;

                        switch (selection) {
                            case "1": // Register Class For Credit Student

                                System.out.println("ID Of Student: ");
                                IDStudent = input.nextLine();
                                student = findStudentByID(IDStudent);

                                if(student == null) {
                                    System.out.println("There is not exist student ID " + IDStudent);
                                    break;
                                }

                                if(!(student instanceof CreditStudent)) {
                                    System.out.println("Student ID " + IDStudent + " is not Credit Student !!" );
                                    break;
                                }


                                System.out.println("ID Of Class: ");
                                IDClass = input.nextLine();
                                Class aClass = findClassByID(IDClass);

                                if(aClass == null) {
                                    System.out.println("There is not exist class ID " + IDClass);
                                    break;
                                }

                                if(((CreditStudent) student).checkExistSubject(aClass.getSubject())) {
                                    System.out.println("This student have studied subject !");
                                    System.out.println("Do you want to update ?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No!");
                                    selection = input.nextLine();
                                    if(selection.equals("1"))  {
                                        ((CreditStudent) student).getCourseResults().remove(student.findCourseResultByIDSubject(aClass.getSubject().getID()));
                                        sr.registerForCreditStudent(student, aClass);
                                        System.out.println("Register is SUCCESSFUL !!");
                                        break;
                                    }
                                    else if(selection.equals("2")) break;
                                    else System.out.println("Please enter 1 or 2 !!!");
                                };

                                if(((CreditStudent) student).canRegisterClass(aClass) == false) {
                                    System.out.println("Check Prerequisite for this Class !");
                                    break;
                                }

                                sr.registerForCreditStudent(student, aClass);

                                break;

                            case "2": // Register Semester For Yearly Student

                                System.out.println("ID Of Student: ");
                                IDStudent = input.nextLine();
                                student = findStudentByID(IDStudent);

                                if(student == null) {
                                    System.out.println("There is not exist student ID " + IDStudent);
                                    break;
                                }

                                if(!(student instanceof YearlyStudent)) {
                                    System.out.println("Student ID " + IDStudent + " is not YearlyStudent !!" );
                                    break;
                                }

                                System.out.println("ID Of Semester: ");
                                IDSemester = input.nextLine();

                                if (((YearlyStudent) student).checkExistSemesterByIDSemester(IDSemester)) {
                                    System.out.println("Register fail ! Student had been registered this semester before! ");
                                    break;
                                }

                                System.out.println("Name Of Semester: ");
                                semesterName = input.nextLine();
                                SemesterOfStudent semesterOfStudent = findSemesterOfStudentByNameAndID(semesterName, IDSemester);

                                if(semesterOfStudent == null) {
                                    System.out.println("Something wrong! Please check information of semester !!" + semesterName);
                                    break;
                                }

                                int i = 0;
                                for (SemesterOfStudent temp: ((YearlyStudent) student).getSemesterOfStudents()) {
                                    if (temp.getGPA() < 5) i++;
                                }

                                if (i != 0) {
                                    System.out.println("This student can register this semester because of previous GPA < 5");
                                    break;
                                }

                                else {
                                    sr.registerForYearlyStudent(student, new SemesterOfStudent(
                                            semesterName,
                                            IDSemester,
                                            semesterOfStudent.getClassroom(),
                                            semesterOfStudent.getTimeStart(),
                                            semesterOfStudent.getTimeEnd()
                                    ));
                                    System.out.println("Register is SUCCESSFUL !!!");
                                }
                                break;

                            case "3": // List Of Class (For Credit Student)
                                showListClass();
                                break;

                            case "4":
                                System.exit(0);

                            default:
                                System.out.println("Please enter \"1 - 4\" \n");
                        }

                    } while (selection != "4");

                    break;

                case "3": // Grading Management

                    do {
                        System.out.println("STUDENT MANAGEMENT");
                        System.out.println("---------------------------------");
                        System.out.println("1. Show Result Student Studying");      //**
                        System.out.println("2. Set Mark");
                        System.out.println("3. Back");
                        System.out.print("Your selection: ");
                        selection = input.nextLine();

                        if(selection.equals("3")) break;

                        switch (selection) {
                            case "1":
                                System.out.println("ID Of Student: ");
                                IDStudent = input.nextLine();
                                student = findStudentByID(IDStudent);

                                if (student == null) {
                                    System.out.println("There is not exist student ID " + IDStudent + "\n");
                                    break;
                                }

                                student.showDetailResultStudying();

                                break;
                            case "2": // Set Mark
                                System.out.println("ID Of Student: ");
                                IDStudent = input.nextLine();
                                student = findStudentByID(IDStudent);

                                if (student == null) {
                                    System.out.println("There is not exist student ID " + IDStudent + "\n");
                                    break;
                                }

                                System.out.println("ID Of Subject: ");
                                IDSubject = input.nextLine();
                                courseResult = student.findCourseResultByIDSubject(IDSubject);

                                if (courseResult == null) {
                                    System.out.println("Student ID have not register this Subject \n");
                                    break;
                                }

                                if(courseResult.getClassify() != "") {
                                    System.out.println("This subject was classified. Do you want to update !");
                                    System.out.println("Please enter 1 to CONTINUE to update Or enter OTHER KEY to GO BACK !");
                                    selection = input.nextLine();
                                    if (!selection.equals("1")) break;
                                }

                                System.out.println("Mark Of Middterm Test: ");
                                markOfMiddterm = input.nextFloat();
                                System.out.println("Mark Of Final Test: ");
                                markOfFinal = input.nextFloat();

                                gfc.setMark(courseResult, markOfMiddterm, markOfFinal);
                                System.out.println("Set mark for student completed !");

                                break;

                            case "3":
                                System.exit(0);
                            default:
                                System.out.println("Please enter \"1 - 3\" \n");
                        }

                    } while (selection != "3");
                    break;



                case "4": // Set Graduation
                    System.out.println("ID Of Student: ");
                    IDStudent = input.nextLine();
                    student = findStudentByID(IDStudent);

                    if (student == null) {
                        System.out.println("There is not exist student ID " + IDStudent + "\n");
                        break;
                    }

                    gra.graduation(student);
                    System.out.println("--------------------------------------------------");

                    break;

                case "5":
                    do {
                        System.out.println("CLASS, SUBJECT, LECTURER MANAGEMENT");
                        System.out.println("---------------------------------");
                        System.out.println("1. Show List Of Subject");      //**
                        System.out.println("2. Show List Of Lecturer");
                        System.out.println("3. Show List Of Class");
                        System.out.println("4. Show List Of Semeter");
                        System.out.println("5. Show List Of Semester For Student");
                        System.out.println("6. Back");
                        System.out.print("Your selection: ");
                        selection = input.nextLine();

                        if (selection.equals("6")) break;

                        switch (selection) {
                            case "1":
                                showListSubject();
                                break;
                            case "2":
                                showListLecture();
                                break;
                            case "3":
                                showListClass();
                                break;

                            case "4":
                                showListSemester();
                                break;

                            case "5":
                                showListSemesterForStudent();
                                break;

                            default:
                                System.out.println("Please enter \"1 - 6\" \n");
                        }
                    }  while (selection != "6");
                    break;

                case "6":
                    writeToFile();
                    System.exit(0);

                    default:
                        System.out.println("Please enter \"1 - 6\" \n");
            }

        } while (selection != "6");
    }


}
