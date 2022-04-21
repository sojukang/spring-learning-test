package nextstep.helloworld.core.di;

import org.springframework.stereotype.Component;

@Component
public class StationConstructorService {

    private final StationRepository stationRepository;

    public StationConstructorService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public String sayHi() {
        return stationRepository.sayHi();
    }
}
