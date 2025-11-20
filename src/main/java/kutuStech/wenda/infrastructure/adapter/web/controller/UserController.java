package kutuStech.wenda.infrastructure.adapter.web.controller;


import kutuStech.wenda.application.port.input.UserServicePort;
import kutuStech.wenda.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServicePort userServicePort;

    @PostMapping
    public ResponseEntity<User> createAdm(@RequestBody User adm) {
        return ResponseEntity.ok(userServicePort.createUser(adm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getAdmById(@PathVariable String id) {
        return ResponseEntity.ok(userServicePort.getUserById(id));
    }
}
