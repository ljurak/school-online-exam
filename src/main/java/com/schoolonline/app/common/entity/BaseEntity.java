package com.schoolonline.app.common.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    public BaseEntity() {
        this.uuid = UUID.randomUUID();
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        BaseEntity other = (BaseEntity) object;
        return uuid.equals(other.getUuid());
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
