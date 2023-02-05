package rob.digital.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import rob.digital.spring6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
