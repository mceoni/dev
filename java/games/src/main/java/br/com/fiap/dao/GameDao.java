package br.com.fiap.dao;

import br.com.fiap.model.Game;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GameDao {

    private EntityManager em;

    public GameDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Game game) {
        em.persist(game);
    }
    public void remover(Game game) {
        Game gameExcluir = em.find(Game.class, game.getId());
        em.remove(gameExcluir);
    }
    public Game buscarGamePorId(Game game) {
        return em.find(Game.class, game.getId());
    }

    public List<Game> listarTodosOsGames() {
        String jpqlQuery = "SELECT g FROM Game g ORDER BY g.titulo ASC";
        return em.createQuery(jpqlQuery, Game.class).getResultList();
    }

    public List<Game> buscarGamesPorTitulo(String titulo) {

        String jpqlQuery = "SELECT g FROM Game g WHERE g.titulo = :titulo";
        return em.createQuery(jpqlQuery, Game.class)
                .setParameter("titulo", titulo)
                .getResultList();
    }

    public List<Game> buscarGamesPorFaixaDeValores(Double valorMin, Double valorMax) {
        String jpqlQuery = "SELECT g FROM Game g WHERE g.valor BETWEEN :valorMin AND :valorMax ORDER BY g.titulo ASC";
        return em.createQuery(jpqlQuery, Game.class)
                .setParameter("valorMin", valorMin)
                .setParameter("valorMax", valorMax)
                .getResultList();

    }
//    public List<Game> buscarTodos() {
//        return em.createQuery("from Game").getResultList();
//    }
    public void atualizar(Game game) {
        em.merge(game);
    }
}
