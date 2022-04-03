package torder.kim.test.member.model.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;

@Table(name = "member")
@Entity
@Getter
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mem_no", nullable = false)
	private Integer id;
	
	@Column(name = "username", nullable = false, length = 50)
	private String username;
	
	@Column(name = "password", nullable = false, length = 300)
	private String password;

	public Member() {}
	
	@Builder
	public Member(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
