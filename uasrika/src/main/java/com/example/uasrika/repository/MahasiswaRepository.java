
package com.example.uasrika.repository;

import com.example.uasrika.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long>{
    Boolean existsByName(String name);
    
}
