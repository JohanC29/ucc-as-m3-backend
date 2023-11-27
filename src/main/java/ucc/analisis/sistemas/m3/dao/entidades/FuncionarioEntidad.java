package ucc.analisis.sistemas.m3.dao.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class FuncionarioEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String nombre;

    private String apellido;

    @Column(nullable = false, name = "iddependencia")
    private Integer iddependencia;

    @Column(nullable = false)
    private String estado;

    // Getters y setters
}