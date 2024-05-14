package com.ntkhoa.jpa.service.impl;

import com.ntkhoa.jpa.dto.request.AuthenticationRequest;
import com.ntkhoa.jpa.exception.AppException;
import com.ntkhoa.jpa.exception.ErrorCode;
import com.ntkhoa.jpa.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepo;

    public boolean authenticate(AuthenticationRequest request){
        var user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(),user.getPassword());
    }
}
