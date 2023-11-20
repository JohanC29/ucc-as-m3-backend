package ucc.analisis.sistemas.m3.interfaz;

import ucc.analisis.sistemas.m3.dao.entidades.EstudianteEntidad;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroEstudianteEntidad;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroSalaEntidad;
import ucc.analisis.sistemas.m3.dto.response.InvitadoDto;
import ucc.analisis.sistemas.m3.dto.response.ObjectResponse;

public interface SalaInterfaz {
    ObjectResponse getSala();

    ObjectResponse getSalaDisponible();

    ObjectResponse getEquipoByIdsala(Integer idsala);

    ObjectResponse getFacultad();

    ObjectResponse getProgramaByIdfacultad(Integer idfacultad);

    ObjectResponse getCursoByIdprograma(Integer idprograma);

    ObjectResponse getEstudianteByDocumento(String documento);

    ObjectResponse getProfesorByIdProfesorByCedula(Integer idprofesor, String cedula);

    ObjectResponse getInvitadoByIdentificacion(String identificacion);

    ObjectResponse saveInvitado(InvitadoDto invitadoDto);

    ObjectResponse saveRegistroSala(RegistroSalaEntidad registroSalaEntidad);

    ObjectResponse saveRegistroEstudiante(RegistroEstudianteEntidad registroEstudianteEntidad);

    ObjectResponse getDatosReporte();

    ObjectResponse saveEstudiante(EstudianteEntidad estudianteEntidad);
}
