package p.tomaszewski.FastRace.logic;

import org.springframework.stereotype.Service;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRepository;
import p.tomaszewski.FastRace.model.projection.DriverReadModel;
import p.tomaszewski.FastRace.model.projection.DriverWriteModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {
    private DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public DriverReadModel createDriver(DriverWriteModel source){
       Driver result =  repository.save(source.toDriver());
        return new DriverReadModel(result);
    }

    public List<DriverReadModel> readAll(){
        return repository.findAll().stream()
                .map(DriverReadModel::new)
                .collect(Collectors.toList());
    }


}
