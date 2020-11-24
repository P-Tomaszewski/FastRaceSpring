package p.tomaszewski.FastRace.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlDriverRepository extends DriverRepository, JpaRepository<Driver, Integer> {
}
