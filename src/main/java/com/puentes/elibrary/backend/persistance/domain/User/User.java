package com.puentes.elibrary.backend.persistance.domain.User;

import com.puentes.elibrary.backend.persistance.domain.Book.Book;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

}
