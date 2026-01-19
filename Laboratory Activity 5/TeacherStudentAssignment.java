public class TeacherStudentAssignment {
    public static void main(String[] args) {

        Student s1 = new Student ("mawis", 21, "female", 1522
         );
        Course c1 = new Course ("OOP1", "Object Oriented Programming");
        Course c2 = new Course ("Math1", "Mathematics in the Modern World");
        Course[] coursesForT1 = { c1, c2 };
        Teacher t1 = new Teacher ("klerkler", 21, "Female", "Math", coursesForT1);

        t1.displayTeacher();
        System.out.println("----------------------------");
        s1.displaystudent();
        System.out.println("----------------------------");
        c1.displaycourse();

    }
}


class Person{
    String name;
    int age;
    String gender;

    Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
void displayinfo() {

    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);

}
}

class Student extends Person{
    int studentid;

     Student(String name, int age, String gender, int studentid){
        super(name,age,gender);
        this.studentid = studentid;
    
}

void displaystudent(){
    System.out.println("--Student Info--");
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);
    System.out.println("Student ID: " + studentid);
}
}

class Course {

    String courseCode;
    String courseName;

    Course(String courseCode, String courseName){
    this.courseCode = courseCode;
    this.courseName = courseName;
    }

    void displaycourse(){
        System.out.println("Course Code: " + courseCode );
        System.out.println("Course name:" + courseName );
    }

}

class Teacher extends Person {
    String department;

     Course[] courses;

     Teacher(String name, int age, String gender, String department,  Course[] courses){
        super(name,age,gender);
        this.department = department;
        this.courses = courses;
     }
    
    void displayTeacher(){
    System.out.println("--Teacher Info--");
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);
    System.out.println("Department : " + department);
    System.out.println("Courses Handled: ");
    if (courses != null && courses.length > 0) {
            for (Course course : courses) {
                course.displaycourse();
            }
    }
}
        
    }
