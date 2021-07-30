import java.util.TreeSet; // mongo DB would implement all query and CRUD data structures

public class Class {

    String class_name; 
    TreeSet students;
    String department;
    int course_number;

    public Class(String class_name){
	    this.class_name = class_name;
	    parseClassName(this.class_name); 
	    students = new TreeSet<Student>();
    }

    private static void parseClassName(String class_name){
	this.department = class_name.substring(0, 3);
	this.course_number = Integer.parseInt(class_name.substring(3).trim());
    }
    // might end on half-hour (maybe registration catalog should have list of times available)
    // ideally data entry doesn't have to think about exact start and end times, e.g., "2 hour block at 10am" -> 10:00--11:50
    // "1.5 hour block at 230pm" -> 2:30--3:50
    public void setTime(int start_hour, int end_hour, int[] weekdays) {
	    // check if valid start and end times, then construct
    }
    public void addInstructor(String instructor_name) {}
    public void removeInstructor(String instructor_name) {}
    public void addStudent(String student_name){
	// Student name isn't unique, but they will like to search by them and not student ID
	// so give them an option (list a table) if the student name
	// input is "First Last"
     }
    public void removeStudent(String student_name){}
}
