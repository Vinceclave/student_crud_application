public class adminAccount {
    private static int nextAdminNumber = 1;
    private int adminNumber;
    private String firstName, lastName, userName, passWord;

    public adminAccount(String firstName, String lastName, String userName, String passWord) {
        this.adminNumber = nextAdminNumber++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
    }

    public adminAccount() {}

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.firstName = firstName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    // getters
    public int getAdminNumber() {
        return adminNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String toString() {
        return "Admin number: " + adminNumber + "\n" +
                "First name: " + firstName + "\n" +
                "Last name: " + lastName + "\n" +
                "Username: " + userName + "\n" +
                "Password: " + passWord;
    }
}