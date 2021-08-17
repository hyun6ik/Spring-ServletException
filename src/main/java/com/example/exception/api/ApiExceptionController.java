package com.example.exception.api;

import com.example.exception.api.dto.MemberDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

        return new MemberDto(id, "hello " + id);
    }
}
