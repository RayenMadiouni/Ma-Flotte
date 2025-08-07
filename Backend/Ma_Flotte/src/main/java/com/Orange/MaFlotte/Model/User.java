package com.Orange.MaFlotte.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.management.relation.Role;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String num;
    private String mail;
    private String role;

    public User(String mail) {

        this.mail = mail;

    }

    public String getNum() {
        return num;
    }

    public String getMail() {
        return mail;
    }

    public String getRole() {
        return role;
    }
}
