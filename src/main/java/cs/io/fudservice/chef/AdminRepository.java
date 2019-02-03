package cs.io.fudservice.chef;

import cs.io.fudservice.entity.Admin;
import cs.io.fudservice.entity.Chef;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
