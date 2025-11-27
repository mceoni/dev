package br.com.fiap;
import java.time.LocalDate;
import java.util.List;

import br.com.fiap.dao.CategoriaDao;
import br.com.fiap.dao.GameDao;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Game;
import br.com.fiap.utils.Conexao;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        //pesquisar(em);
        //listarTodosOsGames(em);
        //buscarGamePeloNome(em);
        //buscarGamePelaFaixaDeValores(em);
        buscarCategoriaPeloId(em);

        em.close();
    }

    public static void listarTodosOsGames(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.listarTodosOsGames();

        for (Game game : games) {
            System.out.println(game);
            System.out.println("--------------------------");
        }
    }

    public static void buscarGamePeloNome(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamesPorTitulo("Mega Man 2".toUpperCase());

        for (Game game : games) {
            System.out.println(game);
            System.out.println("--------------------------");
        }
    }

    public static void buscarCategoriaPeloId(EntityManager em) {
        CategoriaDao categoriaDao = new CategoriaDao(em);
        Categoria categoria = new Categoria();
        categoria.setId(5L);
        Categoria categoriaEncontrada = categoriaDao.buscarCategoriaPeloId(categoria);
        System.out.println(categoriaEncontrada.toString());
    }

    public static void buscarGamePelaFaixaDeValores(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamesPorFaixaDeValores(50.0,200.0);

        for (Game game : games) {
            System.out.println(game);
            System.out.println("--------------------------");
        }
    }

    public static void pesquisar(EntityManager em) {

        GameDao gameDao = new GameDao(em);
        Game game = new Game();
        game.setId(28L);
        Game gameEncontrado = gameDao.buscarGamePorId(game);

        if (gameEncontrado != null) {
            System.out.println(gameEncontrado.toString());
        } else {
            System.out.println("Game não encontrado!");
        }
    }

    public static void cadastrar(EntityManager em) {

        // Criamos uma categoria
        Categoria luta =  new Categoria();
        luta.setId(5L);
        //luta.setNomeCategoria("LUTA");

        // Criamos uma instância de CategoriaDao
        //CategoriaDao categoriaDao = new CategoriaDao(em);

        // Iniciamos uma transação de dados no banco
        em.getTransaction().begin();

        // Chamamos o metodo salvar de CategoriaDao
        // para persistir uma categoria no banco
        //categoriaDao.salvar(luta);

        // Criamos um game de luta
//        Game game1 = new Game();
//        game1.setTitulo("Mortal Kombat");
//        game1.setCategoria(luta);
//        game1.setDataLancamento(LocalDate.of(1992, 2, 1));
//        game1.setFinalizado(true);game1.setProdutora("ACCLAIM");
//        game1.setValor(256.89);
        Game game1 = new Game();
        game1.setTitulo("Street Fighter II");
        game1.setCategoria(luta);
        game1.setDataLancamento(LocalDate.of(1992, 2, 1));
        game1.setFinalizado(true);game1.setProdutora("Capcom");
        game1.setValor(399.99);

        // Criação de uma instância de GameDao
        GameDao gameDao = new GameDao(em);

        // Chamamos o metodo salvar de GameDao
        // para persistir um game no banco
        gameDao.salvar(game1);

        // Efetuamos o commit para sincronizar
        // no banco de dados todas as alteraçòes
        em.getTransaction().commit();

        // Fechamos a EntityManager
        em.close();

    }

//        Game game1 = new Game();
//        game1.setId(4L);
//        game1.setTitulo("Battletoads");
//        game1.setCategoria("Luta");
//        //game1.setDataLancamento(LocalDate.of(1992, 8, 1));
//        game1.setDataLancamento(LocalDate.of(1991, 6, 1));
//        game1.setFinalizado(true);
//        //game1.setProdutora("Tradewest");
//        game1.setProdutora("Tradewest, Rare");
//        game1.setValor(99.89);
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.

//        EntityManager em = Conexao.getEntityManager();
//        GameDao gameDao = new GameDao(em);
//
//        em.getTransaction().begin();
//        //gameDao.salvar(game1);
//        //gameDao.atualizar(game1);
//        gameDao.remover(game1);
//        em.getTransaction().commit();
//        em.close();

}