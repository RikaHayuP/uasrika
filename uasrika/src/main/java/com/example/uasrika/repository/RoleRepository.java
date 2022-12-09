
package com.example.uasrika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.uasrika.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
