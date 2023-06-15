public class StudentAccount extends studentGrades{
    private static int nextStud = 1;
    private String firstName, lastName, age, year, address, course, gender;
    private int studentIDNo;

    public StudentAccount() {} // default constructor

    public StudentAccount(String firstName, String lastName, String age,
                          String gender, String year,
                          String course, String address) {
        super();
        this.studentIDNo = nextStud;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
        this.address = address;
        this.year = year;
        this.gender = gender;
        // let's increment if there's another student to be added
        nextStud++;
    }

    public void setStudentIDNo(int studentIDNo) {
        this.studentIDNo = studentIDNo;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setGrades(double mathGrade, double englishGrade, double comProgGrade) {
        setMathGrade(mathGrade);
        setEnglishGrade(englishGrade);
        setComProgGrade(comProgGrade);
    }

    // getter
    public int getStudentIDNo() {
        return studentIDNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String getAddress() {
        return address;
    }

    public String getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public double getMathGrade() {
        return super.getMathGrade();
    }

    @Override
    public double getEnglishGrade() {
        return super.getEnglishGrade();
    }

    @Override
    public double getComProgGrade() {
        return super.getComProgGrade();
    }

    public String getAverageGrade() {
        return super.gradeAverage();
    }


    public String toString() {
        return "\n" + "Student ID No: " + studentIDNo + "\n" +
                "First name: " + firstName + "\n" +
                "Last name: " + lastName + "\n" +
                "Age : " + age + "\n" +
                "Year: " + year + "\n" +
                "Course: " + course + "\n" +
                "Address: " + address + "\n" +
                "Gender: " + gender + "\n" +
                "---- Grades -----" + "\n" +
                "Math: " + getMathGrade() + "\n" +
                "English: " + getEnglishGrade() + "\n" +
                "Comprog: " + getComProgGrade() + "\n";
    }
}
