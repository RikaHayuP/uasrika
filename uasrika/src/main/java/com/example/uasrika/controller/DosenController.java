
package com.example.uasrika.controller;
import com.example.uasrika.model.Dosen;
import com.example.uasrika.service.DosenService;
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
@RequestMapping("/dosen")
public class DosenController {
    private DosenService dosenService;

    @Autowired
    public DosenController(DosenService dosenService) {
        this.dosenService = dosenService;
    }

    @GetMapping
    public List<Dosen> getAll() {
        return dosenService.getAll();
    }

    @GetMapping("/{id}")
    public Dosen getById(@PathVariable Long id) {
        return dosenService.getById(id);
    }
    
    @PostMapping
    public Dosen create(@RequestBody Dosen dosen) {
        return dosenService.create(dosen);
    }

    @PutMapping("/{id}")
    public Dosen update(@PathVariable Long id, @RequestBody Dosen dosen) {
        return dosenService.update(id, dosen);
    }
 
    @DeleteMapping("/{id}")
    public Dosen delete(@PathVariable Long id) {
        return dosenService.delete(id);
    }
    
}
