package com.restful.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;

    //GET /users
    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
      return service.findAll();
    }
        @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
    User user = service.findOne(id);
    if (user==null){
        throw new UserNotFoundException("id- "+id);
    }


    return user;
        
    }
@Validated
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
       User savedUser= service.save(user);
       //CREATED
        // /user/{id}       savedUser.getId()
        URI location= ServletUriComponentsBuilder
                 .fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(savedUser.getId())
                 .toUri();

        return ResponseEntity.created(location).build();

    }
    //GET /users/{id}
    //retrieveUser(int id)


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.delete(id);
        if (user==null){
            throw new UserNotFoundException("id- "+id);
        }

    }
    //Delete a user  :   DELETE/users/{id} -> /users/1


}
