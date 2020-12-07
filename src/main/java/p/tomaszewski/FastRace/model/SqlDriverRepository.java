package p.tomaszewski.FastRace.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
interface SqlDriverRepository extends DriverRepository, JpaRepository<Driver, Integer> {

}
