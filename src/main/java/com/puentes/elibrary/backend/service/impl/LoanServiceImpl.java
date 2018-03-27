package com.puentes.elibrary.backend.service.impl;

import com.puentes.elibrary.backend.persistance.domain.Loan.Loan;
import com.puentes.elibrary.backend.persistance.repositories.LoanRepository;
import com.puentes.elibrary.backend.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;


    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLoan(Loan loan) {
        loanRepository.delete(loan);
    }
}
