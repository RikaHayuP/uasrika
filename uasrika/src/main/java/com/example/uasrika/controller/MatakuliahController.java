
package com.example.uasrika.controller;

import com.example.uasrika.model.Matakuliah;
import com.example.uasrika.service.MatakuliahService;
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
@RequestMapping("/matakuliah")
public class MatakuliahController {
    private MatakuliahService matakuliahService;

    @Autowired
    public MatakuliahController(MatakuliahService matakuliahService) {
        this.matakuliahService = matakuliahService;
    }

    @GetMapping
    public List<Matakuliah> getAll() {
        return matakuliahService.getAll();
    }

    @GetMapping("/{id}")
    public Matakuliah getById(@PathVariable Long id) {
        return matakuliahService.getById(id);
    }
    
    @PostMapping
    public Matakuliah create(@RequestBody Matakuliah matakuliah) {
        return matakuliahService.create(matakuliah);
    }

    @PutMapping("/{id}")
    public Matakuliah update(@PathVariable Long id, @RequestBody Matakuliah matakuliah) {
        return matakuliahService.update(id, matakuliah);
    }
 
    @DeleteMapping("/{id}")
    public Matakuliah delete(@PathVariable Long id) {
        return matakuliahService.delete(id);
    }
    
    
}
