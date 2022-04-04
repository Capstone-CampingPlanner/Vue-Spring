package com.example.vuespring.repository;

import com.example.vuespring.data.Kind;
import com.example.vuespring.data.Member;
import com.example.vuespring.data.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

//    Optional<Menu> findByKind(Kind kind);

//    @Query("select m from Menu m where m.menuname = :menuname")
//        List<Menu> findAllByMenuList(@Param("menuname") String menuname);


//    List<Menu> findByKind(Kind kind);
//
//    List<Menu> findBykind(Kind kindid);
//
//    List<Menu> findByMember(Member userid);
//        List<Menu> findByMenuname(Menu menuname);


//    Optional<Menu> findByMenuAndDeleteYN(String menuname, String deleteYN);
//
//    Optional<Menu> findByMenuname(String menuname);
}
