package com.crystaldata.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crystaldata.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
