package StudentManagementSystem.Management;

import StudentManagementSystem.*;
import StudentManagementSystem.Class;
import StudentManagementSystem.Student.CreditStudent;
import StudentManagementSystem.Student.Student;
import StudentManagementSystem.Student.YearlyStudent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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

        try (Reader reader = new FileReader("CreditStudents.json")) {

            ArrayList<CreditStudent> creditStudents = new ArrayList<CreditStudent>();

            creditStudents = gson.fromJson(reader, new TypeToken<ArrayList<CreditStudent>>() {
            }.getType());

            for (CreditStudent temp : creditStudents) {
                students.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        try (Reader reader = new FileReader("studentInfo.json")) {
//
//            ArrayList<YearlyStudent> yearlyStudents = new ArrayList<YearlyStudent>();
//
//            yearlyStudents = gson.fromJson(reader, new TypeToken<ArrayList<CreditStudent>>() {
//            }.getType());
//
//            for (YearlyStudent temp : yearlyStudents) {
//                students.add(temp);
//            }
//
//        } catch (IOException e) {
//
//        }

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

        try (Reader reader = new FileReader("Lectures.json")) {

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
//
//        try (Reader reader = new FileReader("studentInfo.json")) {
//
//            ArrayList<Semester> semesters = new ArrayList<Semester>();
//
//            semesters = gson.fromJson(reader, new TypeToken<ArrayList<Semester>>() {
//            }.getType());
//
//            for (Semester temp : semesters) {
//                Management.semesters.add(temp);
//            }
//
//        } catch (IOException e) {
//
//        }
//
//        try (Reader reader = new FileReader("studentInfo.json")) {
//
//            ArrayList<SemesterOfStudent> semesterOfStudents = new ArrayList<SemesterOfStudent>();
//
//            semesterOfStudents = gson.fromJson(reader, new TypeToken<ArrayList<SemesterOfStudent>>() {
//            }.getType());
//
//            for (SemesterOfStudent temp : semesterOfStudents) {
//                Management.semesterOfStudents.add(temp);
//            }
//
//        } catch (IOException e) {
//
//        }




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
    public static SemesterOfStudent findSemesterOfStudentByName(String semesterName) {
        for (SemesterOfStudent temp: semesterOfStudents) {
            if(semesterName.equals(temp.getSemesterName())) {
                return temp;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String selection = "0";
        String IDStudent, studentName, studentSex, studentBirthday, studentDepartment;
        String IDSubject;
        float markOfMiddterm, markOfFinal;
        String IDClass, IDLecture;
        String semesterName;
        Student student;
        CourseResult courseResult;
        StudentManagement sm = new StudentManagement();
        StudentRegister sr = new StudentRegister();
        GradingForCourse gfc = new GradingForCourse();
        Graduation gra = new Graduation();

        initialize();
        System.out.println(((CreditStudent) students.get(0)).showDetail());

        do {
            System.out.println("STUDENT MANAGEMENT");
            System.out.println("---------------------------------");
            System.out.println("1. Student Management");
            System.out.println("2. Student Register");
            System.out.println("3. Grading Management");
            System.out.println("4. Graduation Management");
            System.out.println("5. Exit");
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
                                System.out.println(sm.showListInforStudent());
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

                                if(((CreditStudent) student).canRegisterClass(aClass) == false) {
                                    System.out.println("Check Prerequisite for this Class");
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

                                if(!(student instanceof CreditStudent)) {
                                    System.out.println("Student ID " + IDStudent + " is not Credit Student !!" );
                                    break;
                                }

                                System.out.println("ID Of Semester: ");
                                semesterName = input.nextLine();
                                SemesterOfStudent semesterOfStudent = findSemesterOfStudentByName(semesterName);

                                if(semesterOfStudent == null) {
                                    System.out.println("There is not exist semester ID " + semesterName);
                                    break;
                                }

                                sr.registerForYearlyStudent(student, semesterOfStudent);

                                break;

                            case "3": // List Of Class (For Credit Student)
                                sr.showListOfClass();
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

                                System.out.println(student.showDetailResultStudying());

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
                                }

                                if (!selection.equals("1")) break;

                                System.out.println("Mark Of Middterm Test: ");
                                markOfMiddterm = input.nextFloat();
                                System.out.println("Mark Of Final Test: ");
                                markOfFinal = input.nextFloat();

                                gfc.setMark(courseResult, markOfMiddterm, markOfFinal);

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
                    System.out.println(gra.getDegreeClassification(student));
                    break;

                case "5":
                    System.exit(0);
                    default:
                        System.out.println("Please enter \"1 - 5\" \n");
            }

        } while (selection != "5");
    }

}
