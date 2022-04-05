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
import torder.kim.test.member.model.entity.Member;
import torder.kim.test.menu.model.entity.Menu;

@Table(name = "payment")
@Entity
@Getter @Setter
public class Payment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_no", nullable = false)
    private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "menu_no")
	private Menu menuNo;
	
	@ManyToOne
	@JoinColumn(name = "mem_no")
	private Member memNo;
	
	@Column(name = "menu_num", nullable = false)
	private Integer menuNum;
	
	@Column(name = "pay_date", nullable = false)
	private LocalDateTime payDate;
	
	public Payment() {}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", orderNo=" + menuNo + ", memNo=" + memNo + ", menuNum=" + menuNum + ", payDate="
				+ payDate + "]";
	}
	
	
}
