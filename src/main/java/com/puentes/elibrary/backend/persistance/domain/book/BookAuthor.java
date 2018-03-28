package com.puentes.elibrary.backend.persistance.domain.book;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Matthew on 3/28/2018.
 *
 * @author Matthew
 */

@Data
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id")
    private Book book;

    public BookAuthor(Author author, Book book) {
        this.author = author;
        this.book = book;
    }
}
