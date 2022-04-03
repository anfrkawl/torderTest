package torder.kim.test.payment.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import torder.kim.test.order.model.entity.OrderHistory;

@Table(name = "payment")
@Entity
@Getter @Setter
public class Payment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_no", nullable = false)
    private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "order_no")
	private OrderHistory orderNo;
	
	@Column(name = "pay_date", nullable = false)
	private LocalDateTime payDate;
}
