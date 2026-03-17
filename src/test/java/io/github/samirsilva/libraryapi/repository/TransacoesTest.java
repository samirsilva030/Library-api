package io.github.samirsilva.libraryapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import io.github.samirsilva.libraryapi.service.TransacaoService;

@SpringBootTest
public class TransacoesTest {

    @Autowired
    TransacaoService transacaoService;

    @Test
    void transacaoSimples(){
    transacaoService.executar();
    }
}
