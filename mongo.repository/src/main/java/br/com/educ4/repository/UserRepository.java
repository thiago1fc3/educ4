package br.com.educ4.repository;

import br.com.educ4.entities.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {
    public boolean existsByUsername(String username);
}
