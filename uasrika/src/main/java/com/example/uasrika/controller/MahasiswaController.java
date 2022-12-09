
package com.example.uasrika.controller;

import com.example.uasrika.model.Mahasiswa;
import com.example.uasrika.service.MahasiswaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    private MahasiswaService mahasiswaService;

    @Autowired
    public MahasiswaController(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @GetMapping
    public List<Mahasiswa> getAll() {
        return mahasiswaService.getAll();
    }

    @GetMapping("/{id}")
    public Mahasiswa getById(@PathVariable Long id) {
        return mahasiswaService.getById(id);
    }
    
    @PostMapping
    public Mahasiswa create(@RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.create(mahasiswa);
    }

    @PutMapping("/{id}")
    public Mahasiswa update(@PathVariable Long id, @RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.update(id, mahasiswa);
    }
 
    @DeleteMapping("/{id}")
    public Mahasiswa delete(@PathVariable Long id) {
        return mahasiswaService.delete(id);
    }
    
    
}
