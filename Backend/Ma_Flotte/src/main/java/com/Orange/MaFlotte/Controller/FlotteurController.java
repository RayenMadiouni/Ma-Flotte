package com.Orange.MaFlotte.Controller;


import com.Orange.MaFlotte.Model.Flotteur;
import com.Orange.MaFlotte.Repo.FlotteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flotteur")
@CrossOrigin(origins = "*")
public class  FlotteurController {

    @Autowired
     FlotteurRepo flotteurRepo;
    @PostMapping("/add")
    public void addFlotteur(@RequestBody Flotteur flotteur){
        flotteurRepo.save(flotteur);
    }
    @GetMapping ("/all")
    public List<Flotteur> getAllFlotteur() {
        return flotteurRepo.findAll();
    }


    @GetMapping("/by-num/{num}")
    public ResponseEntity<Flotteur> getFlotteurByNum(@PathVariable String num) {
        Optional<Flotteur> flotteur = flotteurRepo.findByNum(num);
        return flotteur.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }







}








