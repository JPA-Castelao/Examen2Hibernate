package Service;

import config.HibernateConfig;
import entidades.anime;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class animeServices {
    public void crearAnime(String titulo, String estudio, String xenero, int episodios, int anoestreno) {


        try (Session ses = HibernateConfig.getSessionFactory().openSession()) {
            Transaction tx = ses.beginTransaction();

            anime an = new anime();

            an.setTitulo(titulo);
            an.setEstudio(estudio);
            an.setXenero(xenero);
            an.setEpisodios(episodios);
            an.setAnoestreno(anoestreno);
            ses.save(an);
            tx.commit();


        } catch (Exception e) {
            System.err.println(e);
        }

    }


}
