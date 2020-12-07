package br.com.educ4.repository;

import br.com.educ4.core.domain.User;
import br.com.educ4.entities.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<UserDocument, String> {
    boolean existsByUsername(String username);

    @Query("""
            {
                $or:[
                    {'name': {$regex: ?0, '$options': 'i'}}, 
                    {'username': {$regex: ?0, '$options': 'i'}}
                ]
            }
            """)
    List<User> findBySearch(String q);
}
