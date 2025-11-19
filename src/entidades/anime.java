package entidades;


import javax.persistence.*;

@Entity
@Table(name = "anime")
public class anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idanime;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "estudio")
    private String estudio;
    @Column(name = "xenero")
    private String xenero;
    @Column(name = "episodios")
    private int episodios;
    @Column(name = "anoestreno")
    private int anoestreno;


    public int getIdanime() {
        return idanime;
    }

    public void setIdanime(int idanime) {
        this.idanime = idanime;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public int getAnoestreno() {
        return anoestreno;
    }

    public void setAnoestreno(int anoestreno) {
        this.anoestreno = anoestreno;
    }


    public anime(String titulo, String estudio, String xenero, int episodios, int anoestreno) {
        this.titulo = titulo;
        this.estudio = estudio;
        this.xenero = xenero;
        this.episodios = episodios;
        this.anoestreno = anoestreno;
    }

    public anime() {

    }

}
