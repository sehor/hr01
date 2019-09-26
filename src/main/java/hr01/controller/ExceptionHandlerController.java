package hr01.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;



@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    String maxUploadSizeExceededHandler(){

        return "文件大小超出限制！";
    }
}
