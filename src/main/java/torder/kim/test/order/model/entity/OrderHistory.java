package torder.kim.test.order.model.entity;

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
import torder.kim.test.member.model.entity.Member;
import torder.kim.test.menu.model.entity.Menu;

@Table(name = "order_history")
@Entity
@Getter @Setter
public class OrderHistory {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no", nullable = false)
    private Integer id;
	
	@Column(name = "order_date", nullable = false)
	private LocalDateTime orderDate;
	
	@ManyToOne
	@JoinColumn(name = "menu_no")
	private Menu menuNo;
	
	@ManyToOne
	@JoinColumn(name = "mem_no")
	private Member memNo;
	
	@Column(name = "menu_num", nullable = false)
	private int menuNum;
	
	public OrderHistory() {}

	@Override
	public String toString() {
		return "OrderHistory [id=" + id + ", orderDate=" + orderDate + ", menuNo=" + menuNo + ", memNo=" + memNo
				+ ", menuNum=" + menuNum + "]";
	}
	
	
}
