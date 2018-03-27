package com.puentes.elibrary.backend.persistance.domain.Loan;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dateIssued;

    private String dateReturned;
}
