import com.revature.exceptions.InvalidPasswordException;

public class Student throws InvalidPasswordException {

    // instance reference variables
    private String username;
    private String password;
    private int year; // 1, 2, 3, 4, or 4+ year
    private String firstName;
    private String lastName;
    private String major;
    private String minor;

    // setters
    public void setUsername(String username) {this.username = username;}
    public void setYear(int year) {this.year = year;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setMajor(String major) {this.major = major;}
    public void setMinor(String minor) {this.minor = minor;}
    public void setPassword(String currentPassword, String newPassword) throws InvalidPasswordException {
        if currentPassword.equals(password) {this.password = newPassword;}
    }

    // getters
    public String getUsername() {return username;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getMajor() {return major;}
    public String getMinor() {return minor;}
    public int getYear() {return year;}
    public String getPassword(String currentPassword) throws InvalidPasswordException {
        if password.equals(currentPassword) {return password;}
    }

    // constructor
    public Student(String username, String password){
        this.username = username;
        this.password = password;
        // check if this student is already registered somewhere?
    }
}
