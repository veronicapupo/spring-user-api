package br.com.api.model;

import br.com.api.controller.UserJson;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //falar que a classe é uma tabela de banco de dados
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String document;
    private String password;
    private String email;
    private String phone;


    public User(UserJson json) {
        this.id = json.getId();
        this.name = json.getName();
        this.document = json.getDocument();
        this.password = json.getPassword();
        this.email = json.getEmail();
        this.phone = json.getPhone();
    }
}
