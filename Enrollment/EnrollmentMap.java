package Enrollment;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnrollmentMap {
    private Map<Integer, List<Enrollment>> enrollmentListMap = new HashMap<>();
    private void addEnrollmentInListMap (Map<Integer, List<Enrollment>> enrollmentList, int studentId, Enrollment m ) {
        enrollmentList.computeIfAbsent(studentId, k -> new ArrayList<>()).add(m);
    }
    public void addEnrollment (int studentId, Enrollment m) {
        addEnrollmentInListMap(enrollmentListMap, studentId, m);
    }
    public List<Enrollment> getEnrollments (int studentId) {
        return enrollmentListMap.get(studentId);
    }
    public Optional<Double> getGrade (int studentId, String codeEnrollment) {
        List<Enrollment> enrollmentArray = enrollmentListMap.get(studentId);
        if (enrollmentArray == null) {
            return Optional.empty();
        }
        return enrollmentArray.stream().filter(e -> e.getCodeSubject().equals(codeEnrollment)).map(Enrollment::getGrade).findAny();
    }
    public void removeEnrollment (int studentId, String codeEnrollment) {
        boolean enrollmentRemoved = enrollmentListMap.get(studentId).removeIf((e) -> e.getCodeSubject() == codeEnrollment);
        if (enrollmentRemoved) {
            System.out.println("Matrícula removida com sucesso!");
        }
    }
    public Double mediaStudent (int studentId) {
        List<Enrollment> enrollments = enrollmentListMap.get(studentId);
        return enrollments.stream().mapToDouble(Enrollment::getGrade).reduce(0.0, Double::sum) / enrollments.size();
    }
    public Double mediaSubject (String codeEnrollment) {
        Optional<List<Enrollment>> enrollments = enrollmentListMap.values().stream().filter(arrayList -> arrayList.stream().anyMatch(e -> e.getCodeSubject().equals(codeEnrollment))).findAny();
        if (enrollments.isPresent()) {
            return enrollments.stream().flatMap(List::stream).mapToDouble(Enrollment::getGrade).reduce(0.0, Double::sum) / enrollments.stream().flatMap(List::stream).collect(Collectors.toList()).size();
        }
        return 0.0;
    }
    public List<Map.Entry<Integer, Double>> topNEstudentsByMedia (int n) {
    return enrollmentListMap.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> e.getValue().stream()
                      .mapToDouble(Enrollment::getGrade)
                      .average()
                      .orElse(0.0)
            ))
            .entrySet().stream()
            .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
            .limit(n)
            .collect(Collectors.toList());
    }

    public void sout () {
        System.out.println(enrollmentListMap);
    }
}
