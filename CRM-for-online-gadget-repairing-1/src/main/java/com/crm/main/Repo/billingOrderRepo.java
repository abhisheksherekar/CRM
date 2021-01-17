package com.crm.main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.main.Model.BillingOrder;

@Repository
public interface billingOrderRepo extends JpaRepository<BillingOrder, Integer> {

}
