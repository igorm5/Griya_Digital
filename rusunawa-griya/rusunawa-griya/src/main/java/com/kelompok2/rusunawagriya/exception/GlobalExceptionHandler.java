// GlobalExceptionHandler.java
package com.kelompok2.rusunawagriya.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({KamarPenuhException.class, IllegalArgumentException.class})
    public String handlePemesananError(RuntimeException ex, Model model) {
        model.addAttribute("pesanError", ex.getMessage());
        return "penghuni/kamar-penuh";
    }
}