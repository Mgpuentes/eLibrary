package com.puentes.elibrary.backend.persistance.domain.Book;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

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




}
