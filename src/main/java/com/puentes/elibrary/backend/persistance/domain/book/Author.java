package com.puentes.elibrary.backend.persistance.domain.book;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookAuthor> bookAuthors = new HashSet<>();
}
