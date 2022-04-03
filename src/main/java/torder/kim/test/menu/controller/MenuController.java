package torder.kim.test.menu.controller;

import java.security.Principal;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import torder.kim.test.member.model.service.MemberService;
import torder.kim.test.menu.model.dto.Cart;
import torder.kim.test.menu.model.dto.MenuDto;
import torder.kim.test.menu.model.entity.Menu;
import torder.kim.test.menu.model.service.MenuService;

@Controller
@RequiredArgsConstructor
public class MenuController {
	private final MenuService menuService;
	private final MemberService memberService;
	
	@GetMapping("/menu/list")
	public ModelAndView menuList(ModelAndView mv) {
		
		List<Menu>menuList = menuService.selectMenuList();
		
		mv.addObject("menu", menuList);
		mv.setViewName("menu/list");
		return mv;
	}
	
}
