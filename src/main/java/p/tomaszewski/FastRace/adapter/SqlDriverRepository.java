package p.tomaszewski.FastRace.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRepository;


@Repository
interface SqlDriverRepository extends DriverRepository, JpaRepository<Driver, Integer> {

}
