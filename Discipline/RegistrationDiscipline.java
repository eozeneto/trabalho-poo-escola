package Discipline;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class RegistrationDiscipline {
    
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
    
    public boolean verificarDisciplina(String codigo) {
        return Discipline.stream()
                .anyMatch(d -> d.getCode().equals(codigo));
    }
    
    public boolean removerDisciplina (String codigo) {
        return Discipline.removeIf(d -> d.getCode().equals(codigo));
    }
    
    public Collection<Discipline> obterTodasDisciplinas() {
        return Collections.unmodifiableSet(Discipline);
    }

}

