package com.eightbit.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eightbit.books.entity.Tag_master;

@Repository
public interface Tag_masterRepository extends JpaRepository<Tag_master, Long>{

	Tag_master findByTagId(int asInt);

}
