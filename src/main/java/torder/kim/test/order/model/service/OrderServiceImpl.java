package torder.kim.test.order.model.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import torder.kim.test.member.model.entity.Member;
import torder.kim.test.member.model.repository.MemberRepository;
import torder.kim.test.menu.model.entity.Menu;
import torder.kim.test.menu.model.repository.MenuRepository;
import torder.kim.test.order.model.entity.OrderHistory;
import torder.kim.test.order.model.repository.OrderRepository;

@Service("OrderService")
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
	
	private final OrderRepository orderRepository;
	private final MemberRepository memberRepository;
	private final MenuRepository menuRepository;
	
	@Override
	public void order(String userId, Long[] menuId, Long[] menuNum) {

		Optional<Member> id = memberRepository.findByusername(userId);
		Optional<Member> member = memberRepository.findById(id.get().getId());
		for(int i = 0; i < menuId.length; i++) {
			OrderHistory order = new OrderHistory();
			order.setMemNo(member.get());
			
			Optional<Menu> menu = menuRepository.findById(((int)(long)menuId[i]));
			order.setMenuNo(menu.get());
			order.setMenuNum((int)(long)menuNum[i]);
			order.setOrderDate(LocalDateTime.now());
			orderRepository.save(order);
		}
	}

	@Override
	public List<OrderHistory> selectOrderHistory(String name) {
		
		Optional<Member> id = memberRepository.findByusername(name);
		return orderRepository.findAllByMember(id.get());
		
	}

	@Override
	public void deleteByMember(String name) {
		
		System.out.println("name : " + name);
		orderRepository.deleteByMember(name);
		
	}

}
