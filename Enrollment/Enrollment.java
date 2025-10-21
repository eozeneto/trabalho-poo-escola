package Enrollment;

public class Enrollment {
    private final String codeSubject;
    private double grade;


    public Enrollment (String codeSubject, double grade) {
        this.codeSubject = codeSubject;
        this.grade = grade;
    }


    public String getCodeSubject() {
        return codeSubject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return codeSubject + "(" + grade + ")";
    }

}
