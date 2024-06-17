package com.study.study.controller;

import com.study.study.dto.AddUserRequest;
import com.study.study.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @Operation(summary = "회원가입 요청", description = "회원가입 동작을 수행하는 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "회원가입 성공")
    })
    @PostMapping("/user")
    public ResponseEntity<String> signup(@RequestBody AddUserRequest request) {
        userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }

}