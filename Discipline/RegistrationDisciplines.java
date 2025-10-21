package Discipline;

import java.util.LinkedHashSet;
import java.util.Set;

public class RegistrationDisciplines {
    
    private Set<Discipline> Discipline = new LinkedHashSet<>();
    private Set<Discipline> duplicateDiscipline = new LinkedHashSet<>(); 

    public Set<Discipline> getDuplicateDiscipline() {
        return duplicateDiscipline;
    }

    public boolean adicionarDiscipline (Discipline d) { 
    
        if (!Discipline.add(d)) {
            duplicateDiscipline.add(d);
            return false;
        }
        return true;
    }
}
