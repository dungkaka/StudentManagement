package StudentManagementSystem;

public class Lecturer {
    private String ID;
    String name;
    String sex;
    String phoneNumber;
    String birthDay;
    String address;
    String Department;


    public Lecturer(String ID, String name, String sex, String phoneNumber, String birthDay, String address) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.address = address;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }


    public String showDetail() {
        String s = "";
        s += "ID: " + this.getID() + "\n";
        s += "Name: " + this.getName() + "\n";
        s += "Sex: " + this.getSex() + "\n";
        s += "Birthday: " + this.getBirthDay() + "\n";
        s += "Phone Number: " + this.getPhoneNumber() + "\n";
        s += "Address: " + this.getAddress() + "\n";
        s += "Department: " + this.getDepartment() + "\n\n";

        return s;

    }


}
