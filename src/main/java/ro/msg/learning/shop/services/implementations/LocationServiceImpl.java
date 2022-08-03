package ro.msg.learning.shop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.Location;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.services.LocationService;

@Service
public class LocationServiceImpl extends GenericServiceImpl<Location, LocationRepository> implements LocationService {

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        super(locationRepository);
    }

}
