package ucc.analisis.sistemas.m3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto {
    private Integer id;
    private String documento;
    private String nombre;
    private String apellido;
    private String estado;
    private Integer idprograma;
    private Integer idsemestre;
    private Integer idjornada;
    private String descripcionprograma;
    private String descripcionsemestre;
    private String descripcionjornada;
}
