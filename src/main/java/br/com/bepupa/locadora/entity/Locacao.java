package br.com.bepupa.locadora.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import br.com.bepupa.locadora.entity.Usuario;
import br.com.bepupa.locadora.entity.Titulo;

@Entity
public class Locacao
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date data;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "titulo_id", referencedColumnName = "id")
    private Titulo titulo;

    public long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
}