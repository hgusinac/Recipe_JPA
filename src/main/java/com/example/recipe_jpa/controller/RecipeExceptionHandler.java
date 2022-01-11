package com.example.recipe_jpa.controller;

import com.example.recipe_jpa.model.DTO.view.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class RecipeExceptionHandler {

    public ExceptionResponseDTO build(String message,HttpStatus status,WebRequest request){
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO();
        responseDTO.setError(status.name());
        responseDTO.setStatus(status.value());
        responseDTO.setTimeStamp(LocalDateTime.now());
        responseDTO.setPath(request.getDescription(false));
        responseDTO.setMessage(message);
        return responseDTO;
    }


    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ExceptionResponseDTO>handleIllegalArgumentException(IllegalAccessException ex, WebRequest request){
        return ResponseEntity.badRequest().body(build(ex.getMessage(), HttpStatus.BAD_REQUEST,request));
    }



}
