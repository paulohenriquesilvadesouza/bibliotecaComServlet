package com.taleswsouza.biblioteca.servlet;

import com.taleswsouza.biblioteca.dao.LivrosDao;
import com.taleswsouza.biblioteca.entidades.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/pesquisa")
public class Pesquisa extends HttpServlet {

    private LivrosDao dao = new LivrosDao();

    @Override
    public void init() throws ServletException {
        dao.adicionaLivro(new Livro("Java - Como Programar - 10ª Ed", "Paul Deitel", 968));
        dao.adicionaLivro(new Livro("PHP na Prática", "Júlia Silva  ", 312));
        dao.adicionaLivro(new Livro("Building Reactive Microservices in Java", "Clement Escoffier", 83));
        dao.adicionaLivro(new Livro("Migrating to Microservice Databases", "Edson Yanaga", 72));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<ul>");

        String titulo = req.getParameter("titulo");
        List<Livro> livros;
        if (titulo == null || titulo.isEmpty()) {
            livros = dao.buscaTodosLivros();
        } else {
            livros = dao.buscaLivroPorTitulo(titulo);
        }
        for (Livro livro : livros) {
            out.println("<li>" + livro.getTitulo() + "</li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }

}

