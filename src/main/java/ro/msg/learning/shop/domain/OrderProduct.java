package ro.msg.learning.shop.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_product")
public class OrderProduct extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "shipped_from")
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "address_country")
    private String addressCountry;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_county")
    private String addressCounty;

    @Column(name = "address_street")
    private String addressStreet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderProduct that = (OrderProduct) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
