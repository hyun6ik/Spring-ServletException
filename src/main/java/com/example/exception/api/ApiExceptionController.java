package com.example.exception.api;

import com.example.exception.api.dto.MemberDto;
import com.example.exception.exception.BadRequestException;
import com.example.exception.exception.UserException;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ApiExceptionController {

    @GetMapping("/api/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id) {
        if ("ex".equals(id)) {
            throw new RuntimeException("잘못된 사용자");
        }

        if ("bad".equals(id)) {
            throw new IllegalArgumentException("잘못된 입력값");
        }

        if ("user-ex".equals(id)) {
            throw new UserException("사용자 오류");
        }

        return new MemberDto(id, "hello " + id);
    }

    @GetMapping("/api/response-status-ex1")
    public String responseStatusEx1() {
        throw new BadRequestException();
    }

    @GetMapping("/api/response-status-ex2")
    public String responseStatusEx2() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "error.bad", new IllegalArgumentException());
    }
}
