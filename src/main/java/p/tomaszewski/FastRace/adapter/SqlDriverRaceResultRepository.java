package p.tomaszewski.FastRace.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.DriverRaceResultRepository;


@Repository
interface SqlDriverRaceResultRepository extends DriverRaceResultRepository, JpaRepository<DriverRaceResult, Integer> {

}