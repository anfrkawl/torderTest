package torder.kim.test.payment.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import torder.kim.test.order.model.entity.OrderHistory;
import torder.kim.test.order.model.repository.OrderRepository;
import torder.kim.test.payment.model.entity.Payment;
import torder.kim.test.payment.model.repository.PaymentRepository;


@Service("PaymentService")
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
	
	private final PaymentRepository paymentRepository;
	private final OrderRepository orderRepository;

	@Override
	public void payment(String[] orderNo) {
				
		for(int i = 0; i < orderNo.length; i++) {
			Payment pay = new Payment();
			OrderHistory orderHistory = orderRepository.findById(Integer.valueOf(orderNo[i])).get();
			pay.setOrderNo(orderHistory);
			pay.setPayDate(LocalDateTime.now());
			paymentRepository.save(pay);
		}
		
	}

	@Override
	public List<Payment> paymentList() {
		
		List<Payment> paymentList = paymentRepository.findAll();
		
		return paymentList;
	}


}
