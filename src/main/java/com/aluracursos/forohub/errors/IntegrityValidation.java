package com.aluracursos.forohub.errors;

public class IntegrityValidation extends RuntimeException{
    public IntegrityValidation(String s) {
        super(s);
    }
}
