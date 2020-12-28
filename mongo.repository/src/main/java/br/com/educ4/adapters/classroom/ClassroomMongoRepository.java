package br.com.educ4.adapters.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ClassroomMongoRepository implements ClassroomRepositoryPort {

    private final ClassroomRepository repository;

    @Override
    public Classroom findById(String classroomId) {
        return repository.findById(classroomId).orElseThrow(() -> new NoSuchElementException("Classroom not found"));
    }

    @Override
    public Classroom save(Classroom classroom) {
        return repository.save(classroom);
    }

    @Override
    public List<Classroom> findAll() {
        return repository.findAll();
    }
}
