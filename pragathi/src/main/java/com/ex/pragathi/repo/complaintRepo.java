package com.ex.pragathi.repo;

import com.ex.pragathi.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface complaintRepo extends JpaRepository<Complaint,Long> {
}
