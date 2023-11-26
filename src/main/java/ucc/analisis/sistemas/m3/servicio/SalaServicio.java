package ucc.analisis.sistemas.m3.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ucc.analisis.sistemas.m3.dao.entidades.*;
import ucc.analisis.sistemas.m3.dao.especificacion.ProfesorEspecificacion;
import ucc.analisis.sistemas.m3.dao.repositorio.*;
import ucc.analisis.sistemas.m3.dto.response.EstudianteDto;
import ucc.analisis.sistemas.m3.dto.response.InvitadoDto;
import ucc.analisis.sistemas.m3.dto.response.ObjectResponse;
import ucc.analisis.sistemas.m3.interfaz.SalaInterfaz;

import java.util.*;

@Service
public class SalaServicio implements SalaInterfaz {

    @Autowired
    private SalaRepositorio salaRepositorio;

    @Autowired
    private EquipoRepositorio equipoRepositorio;
    @Autowired
    private FacultadRepositorio facultadRepositorio;
    @Autowired
    private ProgramaRepositorio programaRepositorio;
    @Autowired
    private CursoRepositorio cursoRepositorio;
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;
    @Autowired
    private ProfesorRepositorio profesorRepositorio;
    @Autowired
    private InvitadoRepositorio invitadoRepositorio;
    @Autowired
    private RegistroSalaRepositorio registroSalaRepositorio;
    @Autowired
    private RegistroEstudianteRepositorio registroEstudianteRepositorio;

    @Autowired
    private SemestreRepositorio semestreRepositorio;

    @Autowired
    private JornadaRepositorio jornadaRepositorio;

    @Override
    public ObjectResponse getSala() {
        ObjectResponse<SalaEntidad> objectResponse = new ObjectResponse<>();
        List<SalaEntidad> salaEntidadList = salaRepositorio.findAll();
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(salaEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse<SalaEntidad> getSalaDisponible() {
        ObjectResponse<SalaEntidad> objectResponse = new ObjectResponse<>();
        List<SalaEntidad> salaEntidadList = salaRepositorio.getSalaDisponible(new Date());
        objectResponse.setCode((salaEntidadList.isEmpty()) ? -1 : 0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(salaEntidadList);
        return objectResponse;
    }
    @Override
    public ObjectResponse<SalaEntidad> getSalaDisponibleProfesor() {
        ObjectResponse<SalaEntidad> objectResponse = new ObjectResponse<>();
        List<SalaEntidad> salaEntidadList = salaRepositorio.getSalaDisponibleProfesor(new Date());
        objectResponse.setCode((salaEntidadList.isEmpty()) ? -1 : 0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(salaEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse<EquipoEntidad> getEquipoByIdsala(Integer idsala) {
        ObjectResponse<EquipoEntidad> objectResponse = new ObjectResponse<>();
        List<EquipoEntidad> equipoEntidadList = equipoRepositorio.findByIdsala(idsala);
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(equipoEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse<FacultadEntidad> getFacultad() {
        ObjectResponse<FacultadEntidad> objectResponse = new ObjectResponse<>();
        List<FacultadEntidad> facultadEntidadList = facultadRepositorio.findAll();
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(facultadEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse<ProgramaEntidad> getProgramaByIdfacultad(Integer idfacultad) {
        ObjectResponse<ProgramaEntidad> objectResponse = new ObjectResponse<>();
        List<ProgramaEntidad> programaEntidadList = programaRepositorio.findByIdfacultad(idfacultad);
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(programaEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse<CursoEntidad> getCursoByIdprograma(Integer idprograma) {
        ObjectResponse<CursoEntidad> objectResponse = new ObjectResponse<>();
        List<CursoEntidad> cursoEntidadList = cursoRepositorio.findByIdprograma(idprograma);
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(cursoEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse<EstudianteEntidad> getEstudianteByDocumento(String documento) {
        ObjectResponse<EstudianteEntidad> objectResponse = new ObjectResponse<>();
        List<EstudianteEntidad> estudianteEntidadList = estudianteRepositorio.findByDocumento(documento);

        if (estudianteEntidadList.isEmpty()) {
            objectResponse.setCode(-1);
            objectResponse.setMsg("No hay resultados");
            objectResponse.setList(estudianteEntidadList);
            return objectResponse;
        }

        EstudianteDto estudianteDto = new EstudianteDto();

        estudianteDto.setId(estudianteEntidadList.get(0).getId());
        estudianteDto.setDocumento(estudianteEntidadList.get(0).getDocumento());
        estudianteDto.setNombre(estudianteEntidadList.get(0).getNombre());
        estudianteDto.setApellido(estudianteEntidadList.get(0).getApellido());
        estudianteDto.setEstado(estudianteEntidadList.get(0).getEstado());
        estudianteDto.setIdprograma(estudianteEntidadList.get(0).getIdprograma());

        Optional<ProgramaEntidad> programaEntidad = programaRepositorio.findById(estudianteDto.getIdprograma());
        if (programaEntidad.isPresent()) {
            estudianteDto.setDescripcionprograma(programaEntidad.get().getDescripcion());
        }


        estudianteDto.setIdsemestre(estudianteEntidadList.get(0).getIdsemestre());
        Optional<SemestreEntidad> semestreEntidad = semestreRepositorio.findById(estudianteDto.getIdsemestre());
        if (semestreEntidad.isPresent()) {
            estudianteDto.setDescripcionsemestre(semestreEntidad.get().getDescripcion());
        }

        estudianteDto.setIdjornada(estudianteEntidadList.get(0).getIdjornada());
        Optional<JornadaEntidad> jornadaEntidad = jornadaRepositorio.findById(estudianteDto.getIdjornada());

        if (jornadaEntidad.isPresent()) {
            estudianteDto.setDescripcionjornada(jornadaEntidad.get().getDescripcion());
        }
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(estudianteEntidadList);
        objectResponse.setObject(estudianteDto);
        return objectResponse;
    }

    @Override
    public ObjectResponse<ProfesorEntidad> getProfesorByIdProfesorByCedula(Integer idprofesor, String cedula) {
        ObjectResponse<ProfesorEntidad> objectResponse = new ObjectResponse<>();

        Specification<ProfesorEntidad> specification = ProfesorEspecificacion.findByIdProfesorOrCedula(idprofesor, cedula);
        List<ProfesorEntidad> profesorEntidadList = profesorRepositorio.findAll(specification);
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(profesorEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse getInvitadoByIdentificacion(String identificacion) {
        ObjectResponse<InvitadoEntidad> objectResponse = new ObjectResponse<>();
        List<InvitadoEntidad> invitadoEntidadList = invitadoRepositorio.findByIdentificacion(identificacion);

        if (invitadoEntidadList.isEmpty()) {
            objectResponse.setCode(-1);
            objectResponse.setMsg("Invitado no encontrado.");
            return objectResponse;
        }

        InvitadoDto invitadoDto = new InvitadoDto();

        invitadoDto.setId(invitadoEntidadList.get(0).getId());
        invitadoDto.setIdentificacion(invitadoEntidadList.get(0).getIdentificacion());
        invitadoDto.setNombre(invitadoEntidadList.get(0).getNombre());
        invitadoDto.setApellido(invitadoEntidadList.get(0).getApellido());
        invitadoDto.setIdprograma(invitadoEntidadList.get(0).getIdprograma());


        Optional<ProgramaEntidad> programaEntidadList = programaRepositorio.findById(invitadoDto.getIdprograma());

        if (programaEntidadList.isPresent()){
            invitadoDto.setIdfacultad(programaEntidadList.get().getIdfacultad());
        }

        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setObject(invitadoDto);

        objectResponse.setList(invitadoEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse saveInvitado(InvitadoDto invitadoDto) {
        ObjectResponse<InvitadoEntidad> objectResponse = new ObjectResponse<>();
        InvitadoEntidad invitadoEntidad = new InvitadoEntidad();

        invitadoEntidad.setIdentificacion(invitadoDto.getIdentificacion());
        invitadoEntidad.setNombre(invitadoDto.getNombre());
        invitadoEntidad.setApellido(invitadoDto.getApellido());
        invitadoEntidad.setIdprograma(invitadoDto.getIdprograma());

        InvitadoEntidad invitadoEntidadSave = invitadoRepositorio.save(invitadoEntidad);
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setObject(invitadoEntidadSave);
        return objectResponse;
    }

    @Override
    public ObjectResponse saveRegistroSala(RegistroSalaEntidad registroSalaEntidad) {
        ObjectResponse<RegistroSalaEntidad> objectResponse = new ObjectResponse<>();
        RegistroSalaEntidad registroSalaEntidadSave = registroSalaRepositorio.save(registroSalaEntidad);
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setObject(registroSalaEntidadSave);
        return objectResponse;
    }

    @Override
    public ObjectResponse saveRegistroEstudiante(RegistroEstudianteEntidad registroEstudianteEntidad) {
        ObjectResponse<RegistroEstudianteEntidad> objectResponse = new ObjectResponse<>();
        RegistroEstudianteEntidad registroEstudianteEntidadSave = registroEstudianteRepositorio.save(registroEstudianteEntidad);
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setObject(registroEstudianteEntidadSave);
        return objectResponse;
    }

    @Override
    public ObjectResponse getDatosReporte() {
        ObjectResponse<Map<String, String>> objectResponse = new ObjectResponse<>();
        List<Map<String, String>> objectList = registroEstudianteRepositorio.obtenerDatosCompletos();
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(objectList);
        return objectResponse;
    }

    @Override
    public ObjectResponse saveEstudiante(EstudianteEntidad estudianteEntidad) {
        ObjectResponse<EstudianteEntidad> objectResponse = new ObjectResponse<>();
        // Buscar si existe
        List<EstudianteEntidad> estudianteEntidadList = estudianteRepositorio.findByDocumento(estudianteEntidad.getDocumento());
        if (!estudianteEntidadList.isEmpty()) {
            objectResponse.setList(estudianteEntidadList);
            objectResponse.setCode(-1);
            objectResponse.setMsg("Ya exite!");
            return objectResponse;
        }
        if (estudianteEntidad.getId() != null) {
            Optional<EstudianteEntidad> busqueda = estudianteRepositorio.findById(estudianteEntidad.getId());
            if (!busqueda.isEmpty()) {
                objectResponse.setObject(busqueda);
                objectResponse.setCode(-1);
                objectResponse.setMsg("Ya exite!");
                return objectResponse;
            }
        }

        objectResponse.setObject(estudianteRepositorio.save(estudianteEntidad));
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        return objectResponse;
    }

    @Override
    public ObjectResponse getPrograma() {
        ObjectResponse<Map<String,String>> objectResponse = new ObjectResponse<>();

        List<ProgramaEntidad> programaEntidadList = programaRepositorio.findAll();
        List<FacultadEntidad> facultadEntidadList = facultadRepositorio.findAll();

        List<Map<String,String>> resultado = new ArrayList<>();

        for (ProgramaEntidad programa: programaEntidadList) {
            for (FacultadEntidad facultad: facultadEntidadList) {
                if (programa.getIdfacultad() == facultad.getId()){
                    Map<String,String> fila = new HashMap<>();
                    fila.put("id",programa.getId().toString());
                    fila.put("descripcion",programa.getDescripcion());
                    fila.put("descripcionFacultad",facultad.getDescripcion());
                    resultado.add(fila);
                    continue;
                }
            }
        }

        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(resultado);
        return objectResponse;
    }

    @Override
    public ObjectResponse getSemetre() {
        ObjectResponse<SemestreEntidad> objectResponse = new ObjectResponse<>();
        List<SemestreEntidad> semestreEntidadList = semestreRepositorio.findAll();
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(semestreEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse getJornada() {
        ObjectResponse<JornadaEntidad> objectResponse = new ObjectResponse<>();
        List<JornadaEntidad> jornadaEntidadList = jornadaRepositorio.findAll();
        objectResponse.setCode(0);
        objectResponse.setMsg("Exito!");
        objectResponse.setList(jornadaEntidadList);
        return objectResponse;
    }

    @Override
    public ObjectResponse saveEstudianteList(List<EstudianteEntidad> estudianteEntidadList) {
        ObjectResponse<EstudianteEntidad> response = new ObjectResponse<>();
        ArrayList<EstudianteEntidad> arrayList = new ArrayList<>();
        for (EstudianteEntidad estudiante: estudianteEntidadList) {
            // Validamos que el estudiante exista
            List<EstudianteEntidad> estudianteEntidadListBuscada = estudianteRepositorio.findByDocumento(estudiante.getDocumento());
            if (!estudianteEntidadListBuscada.isEmpty()){
                // De no existir se actualizan los datos
                estudiante.setId(estudianteEntidadListBuscada.get(0).getId());
            }
            arrayList.add(estudianteRepositorio.save(estudiante));
        }
        response.setList(arrayList);
        response.setCode(0);
        response.setMsg("Exito");
        return response;
    }

}
