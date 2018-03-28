package com.puentes.elibrary.backend.persistance.domain.book;

import lombok.*;

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
@Table(name = "authors")
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"bookAuthors"})
@EqualsAndHashCode(callSuper = false, exclude = "bookAuthors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookAuthor> bookAuthors = new HashSet<>();
}
