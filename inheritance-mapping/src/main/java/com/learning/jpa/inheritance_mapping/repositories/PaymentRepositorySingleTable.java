package com.learning.jpa.inheritance_mapping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.jpa.inheritance_mapping.entities.PaymentSingleTable;
@Repository
public interface PaymentRepositorySingleTable extends CrudRepository<PaymentSingleTable, Integer>{

	@Query(nativeQuery = true,value = "select * from payment_single_table where payment_mode =:mode")
	public List<PaymentSingleTable> findAllByModeTypeSQL(@Param("mode")String modeType);
}
