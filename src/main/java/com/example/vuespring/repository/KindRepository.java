package com.example.vuespring.repository;

import com.example.vuespring.data.Kind;
import com.example.vuespring.data.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KindRepository extends JpaRepository<Kind, Integer> {
    //
}
