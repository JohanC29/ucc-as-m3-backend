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
@Table(name = "registroportatil")
public class RegistroPortatilEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idfuncionario;
    private Integer idestudiante ;
    private Integer idprofesor ;
    private String celular;
    private Date fechasolicitud;
    private Integer idequipo;
    private String usuarioasigna;
    private Date fechaasigna;
    private Date fecharegreso;
}
