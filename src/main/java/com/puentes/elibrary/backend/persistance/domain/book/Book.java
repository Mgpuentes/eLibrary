package com.puentes.elibrary.backend.persistance.domain.book;

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
@NoArgsConstructor
@ToString(callSuper = true, exclude = "bookAuthors")
@EqualsAndHashCode(callSuper = false, exclude = "bookAuthors")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private Long isbn;

    @Column(unique = true, nullable = false, updatable = false)
    private String title;

    private String publishDate;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookAuthor> bookAuthors = new HashSet<>();
}
