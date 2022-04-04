package torder.kim.test.menu.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Carts {

	private List<Cart> carts = new ArrayList<>();
	
	public Carts() {}
	
	public void onCart(Cart cart) {
		this.carts.add(cart);
		for(int i = 0; i < carts.size() - 1; i++) {
			if(carts.get(i).getUserId().equals(cart.getUserId())) {
				carts.remove(i);
			}
		}
	}
	
	public void removeCart(String name) {
		for(int i = 0; i < carts.size(); i++) {
			if(carts.get(i).getUserId().equals(name)) {
				System.out.println("carts : " + carts);
				carts.remove(i);
			}
		}
		System.out.println(carts);
	}

	@Override
	public String toString() {
		return "Carts [carts=" + carts + "]";
	}
	
	
}
