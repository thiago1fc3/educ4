package br.com.educ4.repository;

import br.com.educ4.core.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
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
