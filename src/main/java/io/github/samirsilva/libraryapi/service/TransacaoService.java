package io.github.samirsilva.libraryapi.service;

import io.github.samirsilva.libraryapi.model.Autor;
import io.github.samirsilva.libraryapi.model.GeneroLivro;
import io.github.samirsilva.libraryapi.model.Livro;
import io.github.samirsilva.libraryapi.repository.AutorRepository;
import io.github.samirsilva.libraryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public void executar(){
        // salva o autor
        Autor autor = new Autor();
        autor.setNome("Francisca");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1951,1,31));

        autorRepository.save(autor);

        // salva o livro
        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Livro da Francisca");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));


        livro.setAutor(autor);

        livroRepository.save(livro);

        if(autor.getNome().equals("josé")){
            throw new RuntimeException("Rollback!");
        };
    }
}
