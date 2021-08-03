import com.revature.exceptions.IncorrectPasswordException;

public class User throws IncorrectPasswordException {

    // instance reference variables
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // setters
    public void setUsername(String username) {this.username = username;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPassword(String currentPassword, String newPassword) throws IncorrectPasswordException {
        if currentPassword.equals(password) {this.password = newPassword;}
	else {throw IncorrectPasswordException;}
    }

    // getters
    public String getUsername() {return username;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getPassword(String currentPassword) throws IncorrectPasswordException {
        if password.equals(currentPassword) {return password;}
	else {throw IncorrectPasswordException;}
    }

    // constructor
    public User(String username, String password){
        this.username = username;
        // check if the user is registered is for the view or some "data integrity service", which will use the DAO
        this.password = password;
    }
}