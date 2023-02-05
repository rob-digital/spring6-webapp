package rob.digital.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import rob.digital.spring6webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
