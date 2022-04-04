package torder.kim.test.order.controller;

import java.security.Principal;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.RequiredArgsConstructor;
import torder.kim.test.menu.model.dto.Cart;
import torder.kim.test.menu.model.dto.Carts;
import torder.kim.test.menu.model.dto.MenuDto;
import torder.kim.test.menu.model.service.MenuService;
import torder.kim.test.order.model.entity.OrderHistory;
import torder.kim.test.order.model.service.OrderService;

@Controller
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;
	private final MenuService menuService;
	private Carts carts = new Carts();
	private Cart cart = new Cart();

	@PostMapping(value = "/order/onCart", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String onCart(MenuDto menuDto, Principal principal) {

		menuDto.setNum(1);
		
		Gson gson = new GsonBuilder()
	            .setPrettyPrinting()
	            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
	            .serializeNulls()
	            .disableHtmlEscaping()
	            .create();
		int result = cart.addCart(principal.getName(), menuDto);
		if(result != 0) {
			carts.onCart(cart);
			System.out.println(carts);
			return gson.toJson(cart);	
			
		} else {
			return gson.toJson("overStock");
		}
		
			
		
	}
	
	@PostMapping(value = "/order/removeCart", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String removeCart(MenuDto menuDto, Principal principal) {
		
		cart.removeCart(principal.getName(), menuDto);
		
		Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
		
		return gson.toJson(cart);
		
	}
	
	@GetMapping("/order/order")
	@ResponseBody
	public ModelAndView orderList(ModelAndView mv, Principal principal) {
		
		List<OrderHistory> orderHistory = orderService.selectOrderHistory(principal.getName());
		mv.addObject("order", orderHistory);
		mv.setViewName("/order/list");		
		
		return mv;
	}
	
	@PostMapping(value = "/order/order", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ModelAndView order(ModelAndView mv, @RequestBody String data) {			
				
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(data);
			
			String userId = (String) jsonObject.get("userId");
			JSONArray menu = (JSONArray) jsonObject.get("menu");
			Long menuId[] = new Long[menu.size()];
			Long menuNum[] = new Long[menu.size()];
			for(int i = 0; i < menu.size(); i++) {

				JSONObject json = (JSONObject) menu.get(i);
				menuId[i] =  (Long) json.get("id");
				menuNum[i] = (Long) json.get("num");
			}
			
			if(menuService.orderMenu(menuId, menuNum) != 0) {
//				orderService.order(userId, menuId, menuNum);
				cart.removeAll(userId);
				carts.removeCart(userId);
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("redirect:/menu/list");
		return mv;
	}
}
