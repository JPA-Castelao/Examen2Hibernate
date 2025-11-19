package Service;

import config.HibernateConfig;
import entidades.boardgame;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class boardgameServices {


    public void crearBoardgame(String nome, String editor, int numeroxogadores, int duracionminutos, int anopublicacion) {
        try (
                Session ses = HibernateConfig.getSessionFactory().openSession();
        ) {
            Transaction transaction = ses.beginTransaction();

            boardgame bg = new boardgame();

            bg.setNome(nome);
            bg.setEditor(editor);
            bg.setNumeroxogadores(numeroxogadores);
            bg.setDuracionminutos(duracionminutos);
            bg.setAnopublicacion(anopublicacion);

            ses.save(bg);
            transaction.commit();

        } catch (Exception e) {
            System.err.println("ERROR AL CREAR BOARDGAME: " + e.getMessage());
            throw new RuntimeException();
        }


    }

    public boardgame leerBoardgame(int id) {
        try (Session ses = HibernateConfig.getSessionFactory().openSession()) {
            return ses.get(boardgame.class, id);

        } catch (Exception e) {
            System.err.println("ERROR AL LEER BOARDGAME" + e.getMessage());
            return null;
        }

    }

    public void actualizarBoardgame(int id, String nome, String editor, int numeroxogadores, int duracionminutos, int anopublicacion) {

        try (Session ses = HibernateConfig.getSessionFactory().openSession()) {
            Transaction trans = ses.beginTransaction();

            boardgame bg = ses.get(boardgame.class, id);
            if (bg != null) {
                bg.setNome(nome);
                bg.setEditor(editor);
                bg.setNumeroxogadores(numeroxogadores);
                bg.setDuracionminutos(duracionminutos);
                bg.setAnopublicacion(anopublicacion);
                ses.update(bg);

            }
        }


    }


    public List<boardgame> listarBoardgames() {
        try (Session ses = HibernateConfig.getSessionFactory().openSession()) {

            List<boardgame> listaBoardgames = ses.createQuery("from boardgame", boardgame.class).getResultList();
            return listaBoardgames;


        } catch (Exception e) {
            System.err.println("ERROR TIPO: " + e.getMessage());
            return null;
        }
    }

    public void mostrarLista(List<boardgame> listaBoardgames) {
        for (boardgame b : listaBoardgames) {
            System.out.println("Id: " + b.getIdxogo() + "Nome: " + b.getNome() + " Editor: " + b.getEditor()
                    + "Xogadores: " + b.getNumeroxogadores()
                    + "Duracion: " + b.getDuracionminutos() + "Publicacion: " + b.getAnopublicacion());

        }
    }

    public void actualizarDuracion(int anoPublicacion) {

        try (Session ses = HibernateConfig.getSessionFactory().openSession()) {
            Transaction trans = ses.beginTransaction();
            List<boardgame> query = ses.createQuery("from boardgame where anopublicacion >= :anoP", boardgame.class)
                    .setParameter("anoP", anoPublicacion)
                    .getResultList();
            if (!query.isEmpty()) {

                for (boardgame b : query) {

                    b.setDuracionminutos(120);
                    ses.update(b);
                }

            } else {

                System.err.println("NINGUN ELEMENTO COINCIDE");

            }

            trans.commit();


        } catch (Exception e) {
            System.err.println("ERROR TIPO AL ACTUALIZAR DURACION: " + e.getMessage());
        }

    }

    public void borrarBoardgame(int id) {

        try (Session ses = HibernateConfig.getSessionFactory().openSession()) {
            Transaction trans = ses.beginTransaction();
            boardgame bg = ses.get(boardgame.class, id);
            if (bg != null) {
                ses.delete(bg);
            } else {

                System.out.println("BOARDGAME NO ENCONTRADO");
            }

            trans.commit();
        } catch (Exception e) {

            System.err.println("ERROR AL BORRAR BOARDGAME: " + e.getMessage());
        }


    }

    public void borrarTodo() {
        try (Session ses = HibernateConfig.getSessionFactory().openSession()) {

            Transaction trans = ses.beginTransaction();

            List<boardgame> listaBoardgames = listarBoardgames();
            for (boardgame b : listaBoardgames) {
                borrarBoardgame(b.getIdxogo());
            }
            trans.commit();


        } catch (Exception e) {
            System.err.println("ERROR AL BORRAR BOARDGAME: " + e.getMessage());
        }
    }
}
