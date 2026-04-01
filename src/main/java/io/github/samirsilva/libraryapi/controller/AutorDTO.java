package io.github.samirsilva.libraryapi.controller;

import io.github.samirsilva.libraryapi.model.Autor;

import java.time.LocalDate;

public record AutorDTO(java.util.UUID id, String nome, LocalDate dataNascimento, String nacionalidade) {

    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
