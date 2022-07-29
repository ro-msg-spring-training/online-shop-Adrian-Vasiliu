package domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "location")
public class Location extends BaseEntity {

    @Column
    private String name;

    @Column(name="address_country")
    private String addressCountry;

    @Column(name="address_city")
    private String addressCity;

    @Column(name="address_county")
    private String addressCounty;

    @Column
    private String street;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Location location = (Location) o;
        return getId() != null && Objects.equals(getId(), location.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
