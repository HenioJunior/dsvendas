package com.crystaldata.dsvendas.services;

import com.crystaldata.dsvendas.dto.SaleSuccessDTO;
import com.crystaldata.dsvendas.dto.SaleSumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crystaldata.dsvendas.dto.SaleDTO;
import com.crystaldata.dsvendas.entities.Sale;
import com.crystaldata.dsvendas.repositories.SaleRepository;
import com.crystaldata.dsvendas.repositories.SellerRepository;

import java.util.List;

@Service
public class SaleService {
	
	@Autowired
	private SellerRepository sellerRepository;

    @Autowired
    private SaleRepository repository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
    	sellerRepository.findAll();
        Page<Sale> result =  repository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
   }

   @Transactional(readOnly = true)
   public List<SaleSumDTO> amountGroupedBySeller(){
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller(){
        return repository.successGroupedBySeller();
    }
}
