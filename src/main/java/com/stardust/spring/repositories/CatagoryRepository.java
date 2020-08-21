package com.stardust.spring.repositories;


import com.stardust.spring.model.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepository extends JpaRepository<Catagory, Long> {
}
