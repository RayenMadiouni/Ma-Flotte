package com.Orange.MaFlotte.Controller;

import com.Orange.MaFlotte.Model.Employe;
import com.Orange.MaFlotte.Repo.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employe")


public class EmployeController {
    @Autowired
    EmployeRepo employeRepo;

    @PostMapping("/add")
    public void addEmploye(@RequestBody Employe employe){employeRepo.save(employe);
    }
}
