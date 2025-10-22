import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        RegistrationDiscipline disciplineRegistry = new RegistrationDiscipline();
        
        loadStudents(studentList);
        loadDisciplines(disciplineRegistry);
        
        System.out.println("== Lista de Estudantes (ordem de cadastro) ==");
        studentList.getAllStudents().forEach(System.out::println);
        System.out.println();

        System.out.println("== Lista de Estudantes (ordenada) ==");
        studentList.sortStudentsByName();
        String studentNames = studentList.getAllStudents().stream()
                                    .map(Student::getName)
                                    .collect(Collectors.joining(", "));
        System.out.println(studentNames);
        System.out.println();

        System.out.println("== Disciplinas (inserção) ==");
        String disciplineNames = disciplineRegistry.getAllDisciplines().stream()
                                        .map(Discipline::getCode)
                                        .collect(Collectors.joining(", "));
        System.out.println(disciplineNames);
        System.out.println();

        System.out.println("== Duplicatas detectadas na importação ==");
        if (disciplineRegistry.getDuplicateDisciplines().isEmpty()) {
            System.out.println("(nenhuma)");
        } else {
            disciplineRegistry.getDuplicateDisciplines().forEach(System.out::println);
        }
        System.out.println();
    }

    private static void loadStudents(StudentList studentList) {
        studentList.addStudent(new Student(1, "Ana"));
        studentList.addStudent(new Student(2, "Bruno"));
        studentList.addStudent(new Student(3, "Carla"));
        studentList.addStudent(new Student(4, "Diego"));
        studentList.addStudent(new Student(5, "Elisa"));
    }

    private static void loadDisciplines(RegistrationDiscipline disciplineRegistry) {
        disciplineRegistry.addDiscipline(new Discipline("MAT101", "Matemática"));
        disciplineRegistry.addDiscipline(new Discipline("PRG201", "Programação"));
        disciplineRegistry.addDiscipline(new Discipline("BD301", "Banco de Dados"));
        disciplineRegistry.addDiscipline(new Discipline("EDF110", "Educação Física"));
        disciplineRegistry.addDiscipline(new Discipline("PRG201", "Programação II"));
    }
}
