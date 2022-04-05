package torder.kim.test.payment.model.service;

import java.util.List;

import torder.kim.test.payment.model.entity.Payment;

public interface PaymentService {

	void payment(String[] orderNo, String[] menuNum, String string);

	List<Payment> paymentList();

}
