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
@Table(name = "REGISTROESTUDIANTE")
public class RegistroEstudianteEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idregistrosala;
    private Integer idestudiante;
    private Integer idequipo;
    private Integer idinvitado;

}
