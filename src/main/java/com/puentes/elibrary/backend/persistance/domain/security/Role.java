package com.puentes.elibrary.backend.persistance.domain.security;

import com.puentes.elibrary.enums.RolesEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Data
@Entity
@ToString(exclude = {"userRoles"})
@EqualsAndHashCode(exclude = {"userRoles"})
@NoArgsConstructor
public class Role {

    /** RolesEnum needed as at now is only 2 and no need to enable auto generation of Id. We will have 2 roles. */
    @Id
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<UserRole> userRoles = new HashSet<>();

    public Role(RolesEnum rolesEnum) {
        this.id = rolesEnum.getId();
        this.name = rolesEnum.getName();
    }
}
