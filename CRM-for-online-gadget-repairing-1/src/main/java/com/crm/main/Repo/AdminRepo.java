package com.crm.main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.main.Model.Admin;


@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	public Admin findByAdminEmailAndAdminPassword(String mailid, String password);
}
