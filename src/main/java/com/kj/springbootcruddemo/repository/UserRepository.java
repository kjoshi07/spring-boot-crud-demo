package com.kj.springbootcruddemo.repository;

import com.kj.springbootcruddemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * a repository class to extend JPA repository which provide all
 * crud method default for that entity .
 * @author KJ
 * @version 1.0
 * @since 2018-05-25
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
