package rob.digital.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import rob.digital.spring6webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
