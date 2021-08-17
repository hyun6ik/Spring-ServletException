package com.example.exception.api;

import com.example.exception.api.dto.MemberDto;
import com.example.exception.exception.UserException;
import com.example.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ApiExceptionV2Controller {




    @GetMapping("/api2/members/{id}")
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
}
