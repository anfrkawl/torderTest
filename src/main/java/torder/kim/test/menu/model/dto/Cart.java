package torder.kim.test.menu.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cart {
	private String userId;
	private List<MenuDto> menu = new ArrayList<>();
	
	public Cart() {}
	
	public int addCart(String userId, MenuDto menuDto) {
		this.userId = userId;
		this.menu.add(menuDto);
		for(int i = 0; i < menu.size() - 1; i++) {			
			if(menu.get(i).getId().equals(menuDto.getId())) {
				menu.get(i).setNum(menu.get(i).getNum() + 1);
				menu.remove(menuDto);
			}
		}
		return checkStock(menu);
	}
	
	private int checkStock(List<MenuDto> menu) {
		int result = 1;
		for(int i = 0; i < menu.size(); i++) {
			if(menu.get(i).getStock() < menu.get(i).getNum()) {
				menu.get(i).setNum(menu.get(i).getNum() - 1);
				result = 0;
			}
		}
		return result;
	}

	public void removeCart(String userId, MenuDto menuDto) {
		for(int i = 0; i < menu.size(); i++) {
			if(menu.get(i).getId().equals(menuDto.getId())) {
				if(menu.get(i).getNum() > 1) {					
					menu.get(i).setNum(menu.get(i).getNum() - 1);
				} else {
					menu.remove(i);
				}
			}
		}
	}
	
	public void removeAll(String userId) {
		menu.removeAll(menu);
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", menu=" + menu + "]";
	}
	
	
}
