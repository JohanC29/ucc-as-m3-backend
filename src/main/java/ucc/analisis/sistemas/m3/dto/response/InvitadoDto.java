package ucc.analisis.sistemas.m3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvitadoDto {

    private Integer id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private Integer idprograma;
    private Integer idfacultad;
}
