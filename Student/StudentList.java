package Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentList {
  private List<Student> students = new ArrayList<>();

  public void addStudent (Student e) {
    students.add(e);
    System.out.println("Estudante adicionado com sucesso!");
  }

  public void removeStudentForId (int id) {
    students.removeIf((s) -> s.getId() == id);
    System.out.println("Estudante removido por id!");
  }

  public void getStudentByIndex (int index) {
    try {
      Student student = students.get(index);
      System.out.println("Estudante: " + student.getName());
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Índice não encontrado!");
    }
  }

  public List<Student> searchStudentsByName (String name) {
    final List<Student> studentsSearchedName = students.stream().
              filter((s) -> s.getName().toLowerCase().startsWith(name.toLowerCase())).
              collect(Collectors.toList());
    return studentsSearchedName;
  }

  public List<Student> sortStudentsByName () {
    students.sort( (a, b) -> { return 1 * a.getName().compareTo(b.getName()); });
    final List<Student> studentsOrderedByName = students;
    return studentsOrderedByName;
  }
}
