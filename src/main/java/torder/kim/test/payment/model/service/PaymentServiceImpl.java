package torder.kim.test.payment.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import torder.kim.test.member.model.entity.Member;
import torder.kim.test.member.model.repository.MemberRepository;
import torder.kim.test.menu.model.entity.Menu;
import torder.kim.test.menu.model.repository.MenuRepository;
import torder.kim.test.payment.model.entity.Payment;
import torder.kim.test.payment.model.repository.PaymentRepository;


@Service("PaymentService")
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
	
	private final PaymentRepository paymentRepository;
	private final MenuRepository menuRepository;
	private final MemberRepository memberRepository;

	@Override
	public void payment(String[] menuNo, String[] menuNum, String name) {
		
		Member member = memberRepository.findByusername(name).get();
		for(int i = 0; i < menuNo.length; i++) {
			Payment pay = new Payment();
			Menu menu = menuRepository.findById(Integer.valueOf(menuNo[i])).get();
			pay.setMenuNo(menu);
			pay.setMemNo(member);
			pay.setMenuNum(Integer.valueOf(menuNum[i]));
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
