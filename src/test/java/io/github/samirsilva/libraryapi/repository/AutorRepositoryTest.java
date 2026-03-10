package io.github.samirsilva.libraryapi.repository;

import io.github.samirsilva.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

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
}
