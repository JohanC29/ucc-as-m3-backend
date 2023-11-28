package ucc.analisis.sistemas.m3.interfaz;

import ucc.analisis.sistemas.m3.dao.entidades.EstudianteEntidad;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroEstudianteEntidad;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroPortatilEntidad;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroSalaEntidad;
import ucc.analisis.sistemas.m3.dto.response.InvitadoDto;
import ucc.analisis.sistemas.m3.dto.response.ObjectResponse;

import java.util.List;

public interface SalaInterfaz {
    ObjectResponse getSala();

    ObjectResponse getSalaDisponible();
    ObjectResponse getSalaDisponibleProfesor();

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

    ObjectResponse getPrograma();

    ObjectResponse getSemetre();

    ObjectResponse getJornada();

    ObjectResponse saveEstudianteList(List<EstudianteEntidad> estudianteEntidadList);

    ObjectResponse getUbicacion();

    ObjectResponse getUsuarioByDocumento(String documento);

    ObjectResponse saveRegistroPortatil(RegistroPortatilEntidad registroPortatilEntidad, Integer idMomento);

    ObjectResponse getSolicitudesPendientes();

    ObjectResponse getEquipoPortatilDisponible();

    ObjectResponse getEquipoPortatilSinDevolver();

    ObjectResponse getUsuarioListaNegra();

    ObjectResponse deleteSolicutudListaNegra(Integer id,String usuario);

    ObjectResponse getReporteModuloPortatiles();

    ObjectResponse getDependencia();
}
