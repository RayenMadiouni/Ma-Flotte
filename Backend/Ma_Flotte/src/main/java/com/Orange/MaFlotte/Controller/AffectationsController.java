package com.Orange.MaFlotte.Controller;


import com.Orange.MaFlotte.Model.Affectation;
import com.Orange.MaFlotte.Repo.AffectationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/affectation")

public class AffectationsController {

    @Autowired
    AffectationRepo affectationRepo;
    @PostMapping("/add")
    public void addAffectation(@RequestBody Affectation affectation){affectationRepo.save(affectation);}
}
