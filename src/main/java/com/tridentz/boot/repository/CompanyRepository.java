package com.tridentz.boot.repository;

import com.tridentz.boot.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    // You can add custom query methods here if needed
}
