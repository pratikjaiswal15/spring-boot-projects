package com.spring.boot_rest.api.spring_boot_rest_api.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
