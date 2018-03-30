package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.backend.persistance.domain.book.Loan;

public interface LoanService {

    /**
     * Create loan with loan instance given.
     *
     * @param loan the loan to save.
     * @return the persisted loan.
     */
    Loan saveLoan(Loan loan);

    /**
     * Retrieve loan by given id.
     *
     * @param id used to retrieve loan.
     * @return the loan that matches the given id.
     */
    Loan getLoanById(Long id);

    /**
     * Delete loan with given instance.
     *
     * @param loan loan to be deleted.
     */
    void deleteLoan(Loan loan);
}
