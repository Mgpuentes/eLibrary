package com.puentes.elibrary.backend.persistance.domain.book;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Loan {

    @GenericGenerator(
            name = "e_Library_StoreSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "E_Library_StoreSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "e_Library_StoreSequenceGenerator")
    private Long id;

    private String dateIssued;

    private String dateReturned;
}
