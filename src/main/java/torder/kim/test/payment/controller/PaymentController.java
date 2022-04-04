package torder.kim.test.payment.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import torder.kim.test.order.model.service.OrderService;
import torder.kim.test.payment.model.entity.Payment;
import torder.kim.test.payment.model.service.PaymentService;

@Controller
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;
	private final OrderService orderService;
	
	@PostMapping("/pay/pay")
	public ModelAndView payment(ModelAndView mv, String[] orderNo, Principal principal) {
		
		for(int i = 0; i < orderNo.length; i++) {			
			System.out.printf("orderNo :" + orderNo[i]);
		}
		paymentService.payment(orderNo);
		orderService.deleteByMember(principal.getName());
		mv.setViewName("redirect:/menu/list");
		return mv;
	}
	
	@GetMapping("/pay/pay")
	public ModelAndView paymentList(ModelAndView mv) {
		
		List<Payment> paymentList = paymentService.paymentList();
		mv.addObject("payment", paymentList);
		mv.setViewName("/payment/list");
		
		return mv;
	}
}
