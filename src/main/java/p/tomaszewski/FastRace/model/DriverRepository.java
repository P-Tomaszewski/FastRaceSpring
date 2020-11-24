package p.tomaszewski.FastRace.model;

import java.util.List;
import java.util.Optional;

public interface DriverRepository {
    List<Driver> findAll();
    Optional<Driver> findById(Integer id);
    Driver save(Driver entity);
    boolean existsById(Integer id);

}
