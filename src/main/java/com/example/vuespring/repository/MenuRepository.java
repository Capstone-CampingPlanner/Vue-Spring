package com.example.vuespring.repository;

import com.example.vuespring.data.Kind;
import com.example.vuespring.data.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

//    List<Menu> findByKind(Kind kind);



}
