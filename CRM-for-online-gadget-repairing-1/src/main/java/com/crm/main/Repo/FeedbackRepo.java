package com.crm.main.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.main.Model.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

	List<Feedback> findByspID(int pid);

}
