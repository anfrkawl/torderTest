package torder.kim.test.member.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import torder.kim.test.member.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	Optional<Member> findByusername(String username);
}
