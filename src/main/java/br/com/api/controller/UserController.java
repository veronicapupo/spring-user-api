package br.com.api.controller;

import br.com.api.model.User;
import br.com.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j //para usar o log
@RestController // definimos que a classe vai ser uma controller
@RequestMapping("/user") // definimos a rota /user
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody UserJson json) {
        if (json.getRisk() && service.isRisk(json.getId())) {
            return new ResponseEntity<>("Usuario é de risco e não foi possivel continuar", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(service.save(new User(json)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<UserJson> getById(@RequestParam int id) {
        return service.findById(id)
                .map(user -> new UserJson(user))
                .map(user -> ResponseEntity.ok(user))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam int id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> updateUserById(@RequestBody UserJson json) {
        service.updateUserById(new User(json));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<UserJson> updateEmailById(@RequestParam String email, @RequestParam int id) {
        return new ResponseEntity<>(new UserJson(service.updateEmailById(email, id)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserJson>> findAllUsers() {
        var list = service.findAllUsers()
                .stream()
                .map(user -> new UserJson(user))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
