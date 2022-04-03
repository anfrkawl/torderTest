package torder.kim.test.menu.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "menu")
@Getter @Setter
@Entity
public class Menu {
	
	 @Id
	 @Column(name = "menu_no", nullable = false)
	 private Integer id;
	 
	 @Column(name = "menu_name", nullable = false, length = 30)
	 private String menuName;
	 
	 @Column(name = "menu_price", nullable = false)
	 private int menuPrice;
	 
	 @Column(name = "menu_cate", nullable = false)
	 private String menuCate;
	 
	 @Column(name = "menu_stock", nullable = false)
	 private int menuStock;
	 
	 @Column(name = "menu_valuable_yn", nullable = false, length = 10)
	 private String menuValuableYn;
	 
	 public Menu() {}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuCate=" + menuCate
				+ ", menuStock=" + menuStock + ", menuValuableYn=" + menuValuableYn + "]";
	}
	 
	  
}
