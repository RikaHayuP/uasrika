
package com.example.uasrika.repository;

import com.example.uasrika.model.Dosen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosenRepository extends JpaRepository<Dosen, Long> {
    Boolean existsByName(String name);
}
