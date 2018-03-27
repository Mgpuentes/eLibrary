package com.puentes.elibrary.backend.persistance.domain.Book;

import com.puentes.elibrary.backend.persistance.domain.User.User;
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
public class Book {

    @Id
    private Long isbn;

    private String title;

    private String publishDate;

    @ManyToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> user = new HashSet<>();
}
