package torder.kim.test.member.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import torder.kim.test.member.model.entity.Member;

@Getter @Setter
@NoArgsConstructor
public class MemberDto {
	private Integer id;
	private String username;
	private String password;
	
	public Member toEntity() {
		return Member.builder()
				.id(id)
				.username(username)
				.password(password)
				.build();
	}
}
