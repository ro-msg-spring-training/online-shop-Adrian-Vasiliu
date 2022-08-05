package ro.msg.learning.shop.domain.DTO.mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.domain.DTO.LocationDTO;
import ro.msg.learning.shop.domain.Location;

@Component
public class LocationMapper {
    public LocationDTO toDTO(Location location) {
    return new LocationDTO(location.getId(), location.getName(), location.getAddressCountry(), location.getAddressCity(),
            location.getAddressCounty(), location.getAddressStreet());
    }

}
