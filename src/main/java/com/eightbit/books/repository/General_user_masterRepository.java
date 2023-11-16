package com.eightbit.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eightbit.books.entity.General_user_master;

@Repository
public interface General_user_masterRepository extends JpaRepository<General_user_master, Long> {

}
