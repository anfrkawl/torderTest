package torder.kim.test.payment.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import torder.kim.test.payment.model.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
