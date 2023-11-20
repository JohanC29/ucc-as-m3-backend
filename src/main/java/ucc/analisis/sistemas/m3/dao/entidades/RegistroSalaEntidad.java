package ucc.analisis.sistemas.m3.dao.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REGISTROSALA")
public class RegistroSalaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idprofesor;
    private Date fechainicial;
    private Date fechafinal;
    private Integer idfacultad;
    private Integer idcurso;
    private Integer idsala;

}
