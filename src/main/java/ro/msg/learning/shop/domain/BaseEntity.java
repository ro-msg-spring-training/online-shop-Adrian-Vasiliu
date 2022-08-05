package ro.msg.learning.shop.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity baseEntity = (BaseEntity) o;
        return id != null && Objects.equals(id, baseEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
