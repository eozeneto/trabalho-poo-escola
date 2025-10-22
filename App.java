import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import Discipline.Discipline;
import Discipline.RegistrationDiscipline;
import Enrollment.Enrollment;
import Enrollment.EnrollmentMap;
import Student.Student;
import Student.StudentList;

public class App {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        RegistrationDiscipline disciplineRegistry = new RegistrationDiscipline();
        EnrollmentMap enrollmentMap = new EnrollmentMap();
        
        loadStudents(studentList);
        loadDisciplines(disciplineRegistry);
        loadEnrollments(enrollmentMap);
        
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
        String disciplineCodes = disciplineRegistry.obterTodasDisciplinas().stream()
                                             .map(Discipline::getCode)
                                             .collect(Collectors.joining(", "));
        System.out.println(disciplineCodes);
        System.out.println();

        System.out.println("== Duplicatas detectadas na importação ==");
        if (disciplineRegistry.getDuplicateDiscipline().isEmpty()) {
            System.out.println("(nenhuma)");
        } else {
            disciplineRegistry.getDuplicateDiscipline().forEach(System.out::println);
        }
        System.out.println();

        System.out.println("== Matrículas e Médias ==");
        for (Student student : studentList.getAllStudents()) {
            List<Enrollment> enrollments = enrollmentMap.getEnrollments(student.getId());
            if (enrollments != null && !enrollments.isEmpty()) {
                String enrollmentsStr = enrollments.stream()
                                                   .map(Enrollment::toString)
                                                   .collect(Collectors.joining(", "));
                double average = enrollmentMap.mediaStudent(student.getId());
                System.out.printf("%s: %s Média: %.2f\n", student.getName(), enrollmentsStr, average);
            }
        }
        System.out.println();
        
        System.out.println("== Top 3 Estudantes por Média ==");
        List<Map.Entry<Integer, Double>> topStudents = enrollmentMap.topNEstudentsByMedia(3);
        topStudents.forEach(entry -> {
            String name = studentList.getAllStudents().stream()
                                    .filter(s -> s.getId() == entry.getKey())
                                    .findFirst()
                                    .map(Student::getName)
                                    .orElse("Desconhecido");
            System.out.printf("%s (ID: %d) - Média: %.2f\n", name, entry.getKey(), entry.getValue());
        });
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

    private static void loadEnrollments(EnrollmentMap enrollmentMap) {
    
        enrollmentMap.addEnrollment(1, new Enrollment("MAT101", 8.5));
        enrollmentMap.addEnrollment(1, new Enrollment("PRG201", 9.0));
        enrollmentMap.addEnrollment(2, new Enrollment("PRG201", 7.0));
        enrollmentMap.addEnrollment(2, new Enrollment("MAT101", 5.0)); 
        enrollmentMap.addEnrollment(3, new Enrollment("BD301", 6.5));
        enrollmentMap.addEnrollment(4, new Enrollment("PRG201", 8.0));
        enrollmentMap.addEnrollment(5, new Enrollment("EDF110", 10.0));
    }
}

