package p.tomaszewski.FastRace.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlRaceRepository extends RaceRepository, JpaRepository<Race, Integer> {

}

