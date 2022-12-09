
package com.example.uasrika.service;

import com.example.uasrika.model.Mahasiswa;
import com.example.uasrika.repository.MahasiswaRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class MahasiswaService {
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    public List<Mahasiswa> getAll() {
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa getById(Long id) {
        return mahasiswaRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mahasiswa not found")
                );
    }

    public Mahasiswa create(Mahasiswa mahasiswa) {
        if (mahasiswa.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Mahasiswa already exists"
            );
        }
        if (mahasiswaRepository.existsByName(mahasiswa.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mahasiswa name already exists");
        }
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa update(Long id, Mahasiswa mahasiswa) {
        getById(id);
        mahasiswa.setId(id);
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa delete(Long id) {
        Mahasiswa mahasiswa = getById(id);
        mahasiswaRepository.delete(mahasiswa);
        return mahasiswa;
    }
    
}
