package br.com.api.controller;

import br.com.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserJson {
    private int id;
    private String name;
    private String document;
    private String password;
    private String email;
    private String phone;
    private Boolean risk;

    public UserJson(User user) {
        this.document = user.getDocument();
        this.email = user.getDocument();
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.phone = user.getPhone();
    }
}
