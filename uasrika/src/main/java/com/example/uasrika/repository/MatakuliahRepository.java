
package com.example.uasrika.repository;

import com.example.uasrika.model.Matakuliah;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatakuliahRepository extends JpaRepository<Matakuliah, Long> {

    public boolean existsByName(String name);

    
}
