 
package com.example.uasrika.service;

import com.example.uasrika.model.Matakuliah;
import com.example.uasrika.repository.MatakuliahRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class MatakuliahService {
    
    private MatakuliahRepository matakuliahRepository;

    @Autowired
    public MatakuliahService(MatakuliahRepository matakuliahRepository) {
        this.matakuliahRepository = matakuliahRepository;
    }

    public List<Matakuliah> getAll() {
        return matakuliahRepository.findAll();
    }

    public Matakuliah getById(Long id) {
        return matakuliahRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matakuliah not found"));
    }

   public Matakuliah create(Matakuliah matakuliah) {
        if (matakuliah.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Matakuliah already exists"
            );
        }
        if (matakuliahRepository.existsByName(matakuliah.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mahasiswa name already exists");
        }
        return matakuliahRepository.save(matakuliah);
    }

    public Matakuliah update(Long id, Matakuliah matakuliah) {
        getById(id);
        matakuliah.setId(id);
        return matakuliahRepository.save(matakuliah);
    }

    public Matakuliah delete(Long id) {
        Matakuliah matakuliah = getById(id);
        matakuliahRepository.delete(matakuliah);
        return matakuliah;
    }

}
