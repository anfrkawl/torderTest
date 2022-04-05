package torder.kim.test.order.model.repository;

import java.util.List;

import torder.kim.test.member.model.entity.Member;
import torder.kim.test.menu.model.entity.Menu;
import torder.kim.test.order.model.entity.OrderHistory;

public interface OrderRepositoryCustom {
	List<OrderHistory> findAllByMember(Member member);
	void deleteByMember(String name);
}
