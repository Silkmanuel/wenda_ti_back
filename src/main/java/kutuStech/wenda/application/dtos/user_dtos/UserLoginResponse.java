package kutuStech.wenda.application.dtos.user_dtos;

import java.time.LocalDateTime;

public record UserLoginResponse(
    String id,
    String name,
    String phoneNumber,
    String token,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
// public record UserRegisterParams(String name, String phoneNumber, String password) {}
    // private String id;
    // private String name;
    // private String phoneNumber;
    // private String password;
    // private LocalDateTime createdAt;
    // private LocalDateTime updatedAt;