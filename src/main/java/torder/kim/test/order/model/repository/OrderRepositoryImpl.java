package torder.kim.test.order.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;

import com.querydsl.jpa.impl.JPAQueryFactory;

import torder.kim.test.member.model.entity.Member;
import torder.kim.test.menu.model.entity.Menu;
import torder.kim.test.order.model.entity.OrderHistory;
import static torder.kim.test.order.model.entity.QOrderHistory.orderHistory;
import static torder.kim.test.menu.model.entity.QMenu.menu;
import static torder.kim.test.member.model.entity.QMember.member;

public class OrderRepositoryImpl implements OrderRepositoryCustom{

	@PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    private final JPAQueryFactory queryFactory;
	
	public OrderRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
    
	@Override
	public List<OrderHistory> findAllByMember(Member mem) {

		List<OrderHistory> results = queryFactory
				.select(orderHistory)
				.from(orderHistory)
				.fetch();
		
		return results;
	}

	@Override
	public void deleteByMember(String name) {
		
		queryFactory
			.delete(orderHistory)
			.where(orderHistory.memNo().username.eq(name))
			.execute();
		
	}
    
    
}
