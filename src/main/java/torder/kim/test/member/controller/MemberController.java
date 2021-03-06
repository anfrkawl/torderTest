package torder.kim.test.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import torder.kim.test.member.model.dto.MemberDto;
import torder.kim.test.member.model.service.MemberService;

@Controller
@AllArgsConstructor
public class MemberController {
	private MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "home/index";
	}
	
	@GetMapping("/member/signup")
	public String signupForm(Model model) {
		model.addAttribute("member", new MemberDto());
		
		return "/member/signupForm";
	}
	
	@PostMapping("/member/signup")
	public String signuip(MemberDto memberDto) {
		memberService.signUp(memberDto);
		
		return "redirect:/";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/loginForm";
	}
}
