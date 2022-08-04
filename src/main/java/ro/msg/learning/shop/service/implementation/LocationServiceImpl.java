package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.Location;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.service.LocationService;

@Service
public class LocationServiceImpl extends GenericServiceImpl<Location, LocationRepository> implements LocationService {

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        super(locationRepository);
    }

}
