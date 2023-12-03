package org.utl.donGalleto.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "materia_prima")
public class MateriaPrima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia_prima")
    private long idMateriaPrima;

    @Column(name = "ingrediente")
    String ingrediente;

    @Column(name = "peso")
    String peso;

    public MateriaPrima() {
    }

    public MateriaPrima(String ingrediente, String peso) {
        this.ingrediente = ingrediente;
        this.peso = peso;
    }

    public MateriaPrima(long idMateriaPrima, String ingrediente, String peso) {
        this.idMateriaPrima = idMateriaPrima;
        this.ingrediente = ingrediente;
        this.peso = peso;
    }

    public long getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(long idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "MateriaPrima{" +
                "idMateriaPrima=" + idMateriaPrima +
                ", ingrediente='" + ingrediente + '\'' +
                ", peso='" + peso + '\'' +
                '}';
    }
}
