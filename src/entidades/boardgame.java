package entidades;

import javax.persistence.*;

@Entity
@Table(name = "boardgame")
public class boardgame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idxogo;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "editor", nullable = false)
    private String editor;
    @Column(name = "numeroxogadores")
    private int numeroxogadores;
    @Column(name = "duracionminutos")
    private int duracionminutos;
    @Column(name = "anopublicacion")
    private int anopublicacion;

    public boardgame() {

    }

    public boardgame(String nome, String editor, int numeroxogadores, int duracionminutos, int anopublicacion) {
        this.nome = nome;
        this.editor = editor;
        this.numeroxogadores = numeroxogadores;
        this.duracionminutos = duracionminutos;
        this.anopublicacion = anopublicacion;
    }


    public int getIdxogo() {
        return idxogo;
    }

    public void setIdxogo(int idxogo) {
        this.idxogo = idxogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getNumeroxogadores() {
        return numeroxogadores;
    }

    public void setNumeroxogadores(int numeroxogadores) {
        this.numeroxogadores = numeroxogadores;
    }

    public int getDuracionminutos() {
        return duracionminutos;
    }

    public void setDuracionminutos(int duracionminutos) {
        this.duracionminutos = duracionminutos;
    }

    public int getAnopublicacion() {
        return anopublicacion;
    }

    public void setAnopublicacion(int anopublicacion) {
        this.anopublicacion = anopublicacion;
    }


}
