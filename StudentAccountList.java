public class StudentAccountList {
    // size sakong array
    private final int studentAccountSize = 20;
    // variable sako pag kuha sa id
    private int searchID;
    // static point sa count sa array
    public int count = 0;
    // mao ni atong array
    public StudentAccount[] list;
    // kani siya mao ni sa akong search ako kuhaon kada search ang account nga ma tugma sa condition
    private StudentAccount searchedStud;
    private StudentAccount currentStudent;

    // mao ni ako constructor
    public StudentAccountList() {
        list = new StudentAccount[studentAccountSize];
    }

    // method ni do para add sa student account
    public void addAccount(StudentAccount e) {
        list[count] = e;
        count++;

        currentStudent = e;
    }

    //mao ni ang method para makuha nato ang list sa students
    public StudentAccount[] getStudentList() {
        StudentAccount[] studentArray = new StudentAccount[count];

        for(int i = 0; i < count; i++) {
            studentArray[i] = list[i];
        }
        return  studentArray;
    }

    // setter ni sa id nato bro
    public void setSearchID (int searchID) {
        this.searchID = searchID;
    }

    // getter sa id
    public int getSearchID() {
        return searchID;
    }

    public StudentAccount CurrentStudent() {
        return currentStudent;
    }

    // mao ni ang method sa pag fetch sa isa ka account gamit ang id
    public StudentAccount searchStudent() {
        StudentAccount[] studentArray = new StudentAccount[count];
        int index = 0;
        for(int i = 0; i < count; i++) {
            studentArray[index] = list[i];
            index++;
        }

        StudentAccount searchedStud = null;

        for(StudentAccount student : studentArray) {
            if(student.getStudentIDNo() == searchID) {
                searchedStud = student;
                break; // Exit the loop after finding the student
            }
        }
        return searchedStud;
    }

    public void deleteAccount() {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (list[i].getStudentIDNo() == searchID) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                list[i] = list[i + 1];
            }
            count--;
        }

    }

    public void editAccount (String firstName, String lastName, String age,
                             String gender, String year,
                             String course, String address) {
        for (int i = 0; i < count; i++) {
            if (list[i].getStudentIDNo() == searchID) {
                list[i].setFirstName(firstName);
                list[i].setLastName(lastName);
                list[i].setAge(age);
                list[i].setYear(year);
                list[i].setAddress(address);
                list[i].setCourse(course);
                list[i].setGender(gender);
                break;
            }
        }
    }

    public int getStudentAccountSize() {
        return studentAccountSize;
    }
}
