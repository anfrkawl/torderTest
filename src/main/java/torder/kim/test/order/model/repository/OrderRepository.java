package torder.kim.test.order.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import torder.kim.test.member.model.entity.Member;
import torder.kim.test.order.model.entity.OrderHistory;

public interface OrderRepository extends JpaRepository<OrderHistory, Integer>, OrderRepositoryCustom{

}
