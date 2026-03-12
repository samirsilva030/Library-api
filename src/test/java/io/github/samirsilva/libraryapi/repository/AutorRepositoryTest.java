package io.github.samirsilva.libraryapi.repository;

import io.github.samirsilva.libraryapi.model.Autor;
import io.github.samirsilva.libraryapi.model.GeneroLivro;
import io.github.samirsilva.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1951,1,31));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo " + autorSalvo);
    }

    @Test
    public void atualizarTest(){
        var id = UUID.fromString("c00fca3c-9056-4587-b7ad-16d6a81866b4");

        Optional<Autor> possivelAutor = repository.findById(id);

        System.out.println(possivelAutor.get());

        if(possivelAutor.isPresent());

        Autor autorEncontrado = possivelAutor.get();
        System.out.println("Dados do Autor");
        System.out.println(autorEncontrado);

        autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));

        repository.save(autorEncontrado );
    }

    @Test
    public void listarTest(){
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        System.out.println("Contagem de autores: " + repository.count());
    }

    @Test
    public void deletePorIdTest(){
        var id = UUID.fromString("db3c886c-0742-4bc2-bf34-3582360055a5");
        repository.deleteById(id);
    }

    @Test
    public void deleteTest(){
        var id = UUID.fromString("e2ef7b66-b416-4e0f-a681-7439ce8c8694");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }
    @Test
    void salvarAutorComLivrosTest(){
        Autor autor = new Autor();
        autor.setNome("Antonio");
        autor.setNacionalidade("Americana");
        autor.setDataNascimento(LocalDate.of(1970,8,5));

        Livro livro = new Livro();
        livro.setIsbn("20847-84874");
        livro.setPreco(BigDecimal.valueOf(204));
        livro.setGenero(GeneroLivro.MISTERIO);
        livro.setTitulo("O roubo da casa assombrada");
        livro.setDataPublicacao(LocalDate.of(1933, 1, 2));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("99999-84874");
        livro2.setPreco(BigDecimal.valueOf(650));
        livro2.setGenero(GeneroLivro.MISTERIO);
        livro2.setTitulo("O roubo da casa assombrada");
        livro2.setDataPublicacao(LocalDate.of(2000, 1, 2));
        livro2.setAutor(autor);


        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);

        //livroRepository.saveAll(autor.getLivros());
    }
    @Test
    void listarLivrosAutor(){
        var id = UUID.fromString("e7185862-d94b-4ec9-b719-438583b91608");
        var autor = repository.findById(id).get();

        List<Livro> livroslista = livroRepository.findByAutor(autor);
        autor.setLivros(livroslista);

        autor.getLivros().forEach(System.out::println);
    }
}
