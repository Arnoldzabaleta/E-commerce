package com.cti.Ecommerce.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role {
    @Id
    private String id;

    @Column(unique = true)
    private  String name;

    private String description;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permission> permissions;
}
