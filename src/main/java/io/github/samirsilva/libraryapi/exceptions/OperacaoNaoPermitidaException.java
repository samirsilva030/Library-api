package io.github.samirsilva.libraryapi.exceptions;

public class OperacaoNaoPermitidaException extends RuntimeException{
    public OperacaoNaoPermitidaException(String message){
        super(message);
    }
}
