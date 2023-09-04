package com.tridentz.boot.service;

import com.tridentz.boot.domain.company.Company;
import com.tridentz.boot.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> findById(int companyId) {
        return companyRepository.findById(companyId);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteById(int companyId) throws EntityNotFoundException {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            companyRepository.deleteById(companyId);
            return;
        }
        throw new EntityNotFoundException("Not Found");
    }
}