package com.Orange.MaFlotte.Controller;

import com.Orange.MaFlotte.Model.Poste;
import com.Orange.MaFlotte.Repo.FlotteurRepo;
import com.Orange.MaFlotte.Repo.PosteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poste")

public class PosteController {

    @Autowired
    FlotteurRepo flotteurRepo;
    @Autowired
    private PosteRepo posteRepo;

    @PostMapping("/add")
    public void addPoste(@RequestBody Poste poste){posteRepo.save(poste);}
}
