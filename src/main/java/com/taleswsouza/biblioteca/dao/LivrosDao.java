package com.taleswsouza.biblioteca.dao;

import com.taleswsouza.biblioteca.entidades.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivrosDao {
    
    private static final List<Livro> livros = new ArrayList<>();
    
    public List<Livro> buscaTodosLivros() {
        return livros;
    }
    
    public List<Livro> buscaLivroPorTitulo(String titulo) {
        List<Livro> livrosARetornar = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosARetornar.add(livro);
            }
        }
        return livrosARetornar;
    }
    
    public void adicionaLivro(Livro livro) {
        livros.add(livro);
    }
    
    public void removeLivro(Livro livro) {
        livros.remove(livro);
    }
}
