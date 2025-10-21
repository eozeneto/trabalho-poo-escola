import Student.Student;
import Student.StudentList;

public class App {
  public static void main (String[] args) {
    StudentList students = new StudentList();
    Student student = new Student(1, "Luiz Matheus Soares");
    Student student1 = new Student(2, "José Torres Neto");
    Student student2 = new Student(3, "José Roberto");
    Student student3 = new Student(4, "Luiz Henrique");
    students.addStudent(student);
    students.addStudent(student1);
    students.addStudent(student2);
    students.addStudent(student3);
    System.out.println(students.sortStudentsByName());
  }
}
