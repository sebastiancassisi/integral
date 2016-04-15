package ar.com.integral.bean;

import ar.com.integral.database.HibernateHelper;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author cecilio alvarez caules contacto@arquitecturajava.com
 * @version 1.0
 */


@Entity
@Table(name = "Categorias")
public class Categoria implements Serializable {

    @Id
    private int id;
    private String descripcion;

    @Override
    public int hashCode() {
        return id;

    }

    @Override
    public boolean equals(Object o) {
        int categoriaId = ((Categoria) o).getId();
        return id == categoriaId;

    }

    @OneToMany
    @JoinColumn(name = "categoria")
    private List<Libro> listaDeLibros;

    public List<Libro> getListaDeLibros() {
        return listaDeLibros;
    }

    public void setListaDeLibros(List<Libro> listaDeLibros) {
        this.listaDeLibros = listaDeLibros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @SuppressWarnings("unchecked")
    public static List<Categoria> buscarTodos() {

        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        List<Categoria> listaDeCategorias = session.createQuery(" from Categoria categoria").list();
        session.close();
        return listaDeCategorias;

    }

    public Categoria() {
        super();
    }

    public Categoria(int id) {
        super();
        this.id = id;
    }

    public static Categoria buscarPorClave(int id) {

        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        Query consulta = session
                .createQuery(" from Categoria categoria where id=:id");
        consulta.setInteger("id", id);

        Categoria categoria = (Categoria) consulta.uniqueResult();
        session.close();
        return categoria;

    }

}
