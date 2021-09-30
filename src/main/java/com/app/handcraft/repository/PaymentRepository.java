package com.app.handcraft.repository;

import com.app.handcraft.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByOdId(Long odId);

}
