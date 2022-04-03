package torder.kim.test.member.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import torder.kim.test.member.model.dto.MemberDto;
import torder.kim.test.member.model.entity.Member;
import torder.kim.test.member.model.repository.MemberRepository;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService{

	private MemberRepository memberRepository;
	
	@Transactional
	public Integer signUp(MemberDto memberDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
		
		return memberRepository.save(memberDto.toEntity()).getId();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Member> memberWrapper = memberRepository.findByusername(username);
		Member member = memberWrapper.get();

		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if("admin".equals(username)) {
			authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
		}
		return new User(member.getUsername(), member.getPassword(), authorities);
	}
}
