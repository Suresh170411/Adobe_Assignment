package com.adobe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adobe.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByEmail(String email);

	@Query(value = "select u.name,COALESCE(p.count,0) AS post_count, COALESCE(p.post_likes,0) as post_like from user u "
			+ "left join (select user_id, count(*) as count, sum(likes) as post_likes from post group by user_id) p "
			+ "On p.user_id = u.id ORDER BY post_count DESC, post_like DESC LIMIT 5", nativeQuery = true)
	public List<User> topFiveByPost();
}
