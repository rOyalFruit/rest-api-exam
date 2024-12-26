package com.example.rest.global.globalExceptionHandler;

import com.example.rest.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

// @ControllerAdvice: Spring MVC에서 전역적으로 예외를 처리하기 위해 사용하는 어노테이션.
@ControllerAdvice // 모든 컨트롤러에서 발생하는 예외를 한 곳에서 처리할 수 있음
// @RequiredArgsConstructor: Lombok에서 제공하는 어노테이션으로, final이나 @NonNull이 붙은 필드를 대상으로 생성자를 자동 생성.
@RequiredArgsConstructor // 의존성 주입(Dependency Injection)을 위해 사용. 이 코드에서는 의존성 주입을 받을 필드가 없으므로 현재는 의미가 없음.
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class) // @ExceptionHandler: 특정 예외를 처리하기 위한 메서드에 붙이는 어노테이션
    public ResponseEntity<RsData<Void>> handle(NoSuchElementException ex) { // NoSuchElementException(컬렉션이나 Optional 등에서 값을 찾지 못했을 때 발생)이 발생했을 때 실행됨.
        return ResponseEntity // ResponseEntity: Spring에서 HTTP 응답을 생성하기 위해 사용하는 클래스. HTTP 상태 코드와 응답 본문(body)을 설정할 수 있음.
                .status(HttpStatus.NOT_FOUND)
                .body(new RsData<>(
                        "404-1",
                        "해당 데이터가 존재하지 않습니다."
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RsData<Void>> handle(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .filter(error -> error instanceof FieldError)
                .map(error -> (FieldError) error)
                .map(error -> error.getField() + "-" + error.getCode() + "-" + error.getDefaultMessage())
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.joining("\n"));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RsData<>(
                        "400-1",
                        message
                ));
    }
}
