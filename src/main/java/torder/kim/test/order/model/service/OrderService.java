package torder.kim.test.order.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import torder.kim.test.order.model.entity.OrderHistory;


public interface OrderService {

	void order(String userId, Long[] menuId, Long[] menuNum);

	List<OrderHistory> selectOrderHistory(String name);

	void deleteByMember(String[] orderNo);

}
