package p.tomaszewski.FastRace.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface SqlDriverRaceResultRepository extends DriverRaceResultRepository, JpaRepository<DriverRaceResult, Integer> {

}