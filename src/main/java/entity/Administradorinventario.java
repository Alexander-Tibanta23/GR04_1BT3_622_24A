package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "administradorinventario")
public class Administradorinventario {
    @Id
    @Column(name = "idAdministradorInventario", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idAdministradorInventario", nullable = false)
    private Usuario usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

}