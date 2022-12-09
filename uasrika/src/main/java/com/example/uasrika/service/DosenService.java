
package com.example.uasrika.service;

import com.example.uasrika.model.Dosen;
import com.example.uasrika.repository.DosenRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class DosenService {
    
    private DosenRepository dosenRepository;

    public List<Dosen> getAll() {
        return dosenRepository.findAll();
    }

    public Dosen getById(Long id) {
        return dosenRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dosen not found")
                );
    }

    public Dosen create(Dosen dosen) {
        if (dosen.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Dosen already exists"
            );
        }
        if (dosenRepository.existsByName(dosen.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Dosen name already exists");
        }
        return dosenRepository.save(dosen);
    }

    public Dosen update(Long id, Dosen dosen) {
        getById(id);
        dosen.setId(id);
        return dosenRepository.save(dosen);
    }

    public Dosen delete(Long id) {
        Dosen dosen = getById(id);
        dosenRepository.delete(dosen);
        return dosen;
    }
    
}
