package br.com.educ4.repository;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryPort {

}
