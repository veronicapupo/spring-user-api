package br.com.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //falar que a classe é uma tabela de banco de dados
public class User {

    @Id
    private int id;
    private String name;
    private String document;
    private String password;
    private String email;
    private String phone;

}
