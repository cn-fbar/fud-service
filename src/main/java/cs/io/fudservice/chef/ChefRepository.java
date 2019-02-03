package cs.io.fudservice.chef;

import cs.io.fudservice.entity.Chef;
import org.springframework.data.repository.CrudRepository;

public interface ChefRepository extends CrudRepository<Chef, Long> {
}
