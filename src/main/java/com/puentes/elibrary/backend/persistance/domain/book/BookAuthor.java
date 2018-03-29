package com.puentes.elibrary.backend.persistance.domain.book;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

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
