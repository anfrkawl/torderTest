package torder.kim.test.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MenuDto {

	private Integer id;
	private String name;
	private Integer price;
	private Integer stock;
	private Integer num;
	private String valuableYn;
	
	public MenuDto() {}

	@Override
	public String toString() {
		return "MenuDto [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", num=" + num
				+ ", valuableYn=" + valuableYn + "]";
	}

	
	
	
}
