package br.com.wsilva.redis.controller;

import br.com.wsilva.redis.model.UserEntity;
import br.com.wsilva.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/save")
    public String save() {
        repository.save(new UserEntity(1, "Wellington", "123"));
        repository.save(new UserEntity(2, "Rafael", "123"));
        repository.save(new UserEntity(3, "Gabi", "123"));
        repository.save(new UserEntity(4, "Jaqueline", "123"));

        return HttpStatus.OK.toString();
    }

    @RequestMapping("/listAll")
    public List<UserEntity> listAll() {
        return (List<UserEntity>) repository.findAll();
    }

    @RequestMapping("/{id}")
    public UserEntity findOne(@PathVariable("id") Integer id) {
        return repository.findById(id).get();
    }
}
