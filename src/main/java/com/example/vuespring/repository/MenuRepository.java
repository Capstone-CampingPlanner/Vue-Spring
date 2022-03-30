package com.example.vuespring.repository;

import com.example.vuespring.data.Kind;
import com.example.vuespring.data.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Optional<Menu> findByKind(Kind kind);

    @Query("select m from Menu m where m.kind = 1")
    List<Menu> findAllByMenuList(String kind);

//    List<Menu> findByKind(Kind kind);



}
