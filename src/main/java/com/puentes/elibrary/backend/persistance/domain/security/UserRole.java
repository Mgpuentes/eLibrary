package com.puentes.elibrary.backend.persistance.domain.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Data
@Entity
@NoArgsConstructor  // Creates a no argument constructor for the class.
@ToString
@EqualsAndHashCode
public class UserRole {

    @GenericGenerator(
            name = "e_Library_StoreSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "E_Library_StoreSequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "e_Library_StoreSequenceGenerator")
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id")
    private Role role;


    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}
