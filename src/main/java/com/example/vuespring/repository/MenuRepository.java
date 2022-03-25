package com.example.vuespring.repository;

import com.example.vuespring.data.Member;
import com.example.vuespring.data.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
