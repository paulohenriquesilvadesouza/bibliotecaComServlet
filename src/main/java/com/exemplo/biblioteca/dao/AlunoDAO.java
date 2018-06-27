package com.exemplo.biblioteca.dao;

import com.exemplo.biblioteca.entidades.Aluno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AlunoDAO {
    @PersistenceContext(unitName = "bibliotecaPU")
    EntityManager em;

    public List<Aluno> buscaTodosAlunos() {
        try {
            TypedQuery<Aluno> q = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
            return q.getResultList();
        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public List<Aluno> buscaAlunoPorNome(String nome) {
        List<Aluno> alunos = new ArrayList<>();
        for (Aluno aluno : buscaTodosAlunos()) {
            if (aluno.getNome().toLowerCase().contains(nome.toLowerCase())) {
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public void adicionaAluno(Aluno aluno) {
        em.persist(aluno);
        }

    public void removeAluno(Aluno aluno) {
        em.remove(aluno);
    }
}
