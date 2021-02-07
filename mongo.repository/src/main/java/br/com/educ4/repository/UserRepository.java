package br.com.educ4.repository;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryPort {
    @Query("""
            {
                $or:[
                    {'name': {$regex: ?0, '$options': 'i'}}, 
                    {'username': {$regex: ?0, '$options': 'i'}}
                ]
            }
            """
    )
    <T> List<T> findBySearch(String q, Class<T> projection);
}
