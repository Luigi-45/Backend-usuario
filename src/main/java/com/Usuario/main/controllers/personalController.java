package com.Usuario.main.controllers;

import com.Usuario.main.entities.Personal;
import com.Usuario.main.services.Personal.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/personal")
@CrossOrigin(origins = "*")
public class personalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping
    public List<Personal> findAll(){
        return (ArrayList<Personal>) personalService.finndAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Personal>> findById(@PathVariable int id){
        Optional<Personal> personal = personalService.findById(id);
        return ResponseEntity.ok(personal);
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Optional<Personal>> findByEmail(@PathVariable String email){
        Optional<Personal> personal = personalService.findByEmail(email);
        return ResponseEntity.ok(personal);
    }

    @PostMapping("/save")
    public Personal save(@RequestBody Personal personal){
        return personalService.save(personal);
    }

    @PutMapping("/update/{id}")
    public Personal update (@RequestBody Personal personal){
        return personalService.update(personal);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> delete (@PathVariable int id){
        personalService.delete(id);

        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
}
