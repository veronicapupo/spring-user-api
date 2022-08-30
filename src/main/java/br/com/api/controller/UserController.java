package br.com.api.controller;

import br.com.api.model.User;
import br.com.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j //para usar o log
@RestController // definimos que a classe vai ser uma controller
@RequestMapping("/user") // definimos a rota /user
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping
    public User getById(@RequestParam int id) {
        return service.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam int id) {
        log.info("acessou o endpoint de delete");
        service.deleteById(id);
    }

    @PutMapping
    public void updateUserById(@RequestBody User user) {
        service.updateUserById(user);

    }

    @PatchMapping
    public User updateEmailById(@RequestParam String email, @RequestParam int id) {
        return service.updateEmailById(email, id);

    }
}
