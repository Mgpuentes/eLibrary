package com.puentes.elibrary.backend.persistance.repositories;

import com.puentes.elibrary.backend.persistance.domain.book.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
}
