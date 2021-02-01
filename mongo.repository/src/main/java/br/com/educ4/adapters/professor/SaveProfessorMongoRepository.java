package br.com.educ4.adapters.professor;

import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SaveProfessorMongoRepository implements ProfessorRepositoryPort {

    private final ProfessorRepository repository;

    @Override
    public Professor findById(String professorId) {
        return repository.findById(professorId).orElseThrow(() -> new NoSuchElementException("Professor not found!"));
    }

    @Override
    public Professor save(Professor professor) {
        return repository.save(professor);
    }

    @Override
    public List<Professor> findAll() {
        return repository.findAll();
    }
}
