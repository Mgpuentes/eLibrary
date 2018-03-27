package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.backend.persistance.domain.Loan.Loan;

public interface LoanService {

    Loan saveLoan(Loan loan);

    Loan getLoanById(Long id);

    void deleteLoan(Loan loan);
}
