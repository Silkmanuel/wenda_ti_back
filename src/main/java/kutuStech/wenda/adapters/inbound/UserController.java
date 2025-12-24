package kutuStech.wenda.adapters.inbound;


import kutuStech.wenda.application.dtos.user_dtos.UserLoginResponse;
import kutuStech.wenda.application.dtos.user_dtos.UserRegisterParams;
import kutuStech.wenda.application.services.UserService;
import kutuStech.wenda.domain.user.User;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@SecurityRequirement(name = "ApiKeyAuth")  
@SecurityRequirement(name = "Bearer Authentication")  
public class UserController {
    private final UserService userService;
    

    @PostMapping("/register")
    public ResponseEntity<User> createAdm(@RequestBody UserRegisterParams adm) {
        return ResponseEntity.ok(userService.createUser(adm));
    }
//    /api/user/login
//    /api/user/register
    @GetMapping("/{phonenumber}")
    public ResponseEntity<User> getAdmById(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(userService.getUserByPhonenUMBER(phoneNumber));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllAdms() {
        return ResponseEntity.ok(userService.getAll());
    }
    //
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(String phoneNumber, String password) {
        return ResponseEntity.ok(userService.login(phoneNumber, password));
    }
}
