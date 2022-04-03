package torder.kim.test.menu.model.dto;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	private String userId;
	private List<MenuDto> menu = new ArrayList<>();
	
	public Cart() {}
	
	public void addCart(String userId, MenuDto menuDto) {
		this.userId = userId;
		this.menu.add(menuDto);
		for(int i = 0; i < menu.size() - 1; i++) {			
			if(menu.get(i).getId().equals(menuDto.getId())) {
				menu.get(i).setNum(menu.get(i).getNum() + 1);
				menu.remove(menuDto);
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
