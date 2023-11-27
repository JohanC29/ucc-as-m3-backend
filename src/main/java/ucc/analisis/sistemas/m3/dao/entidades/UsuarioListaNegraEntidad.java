package ucc.analisis.sistemas.m3.dao.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuariolistanegra")
public class UsuarioListaNegraEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idfuncionario;
    private Integer idestudiante ;
    private Integer idprofesor ;
    @Column(name = "fechacreacion")
    private LocalDateTime fechaCreacion;
}
