package com.exemplo.biblioteca.servlet;

import com.exemplo.biblioteca.dao.LivrosDao;
import com.exemplo.biblioteca.entidades.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/pesquisar-livro-servlet")
public class PesquisaLivroServlet extends HttpServlet {

    private LivrosDao dao = new LivrosDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<table border=\"1\">");
        out.println("<tr><th>Titulo</th><th>Autor</th><th>Páginas</th></tr>");

        String titulo = req.getParameter("titulo");
        List<Livro> livros;
        if (titulo == null || titulo.isEmpty()) {
            livros = dao.buscaTodosLivros();
        } else {
            livros = dao.buscaLivroPorTitulo(titulo);
        }
        for (Livro livro : livros) {
            out.println("<tr><td>" + livro.getTitulo() + "</td><th>" + livro.getAutor() + "</td><td>" + livro.getNumPaginas() + "</td></tr>");
        }

        out.println("</table>");
        out.println("<a href=\"/biblioteca\">Biblioteca</a>");
        out.println("</body></html>");
    }

}
