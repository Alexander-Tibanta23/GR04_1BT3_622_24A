package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "administradoresinventario")
public class Administradoresinventario {
    @Id
    @Column(name = "numeroCedula", nullable = false, length = 20)
    private String numeroCedula;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numeroCedula", nullable = false)
    private Usuario usuarios;

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

}