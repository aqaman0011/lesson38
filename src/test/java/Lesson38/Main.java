package Lesson38;

public class Main {

    public static void main(String[] args) {
        //save info in DB
        Student student = new Student();
        student.setId(1);
        student.setName("Taras");
        student.setAge(25);
        student.save();

        //gets info from DB
        int studentId = 1;
        Student retrievedStudent = Student.getById(studentId);
        if (retrievedStudent != null) {
            System.out.println("ID: " + retrievedStudent.getId());
            System.out.println("NAME: " + retrievedStudent.getName());
            System.out.println("AGE: " + retrievedStudent.getAge());
        } else {
            System.out.println("Students for this id " + studentId + " not found.");
        }
    }
}
