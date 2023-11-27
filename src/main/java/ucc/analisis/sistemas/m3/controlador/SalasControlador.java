package ucc.analisis.sistemas.m3.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucc.analisis.sistemas.m3.dao.entidades.EstudianteEntidad;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroEstudianteEntidad;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroPortatilEntidad;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroSalaEntidad;
import ucc.analisis.sistemas.m3.dto.response.InvitadoDto;
import ucc.analisis.sistemas.m3.dto.response.ObjectResponse;
import ucc.analisis.sistemas.m3.interfaz.SalaInterfaz;

import java.util.List;

@RestController
@RequestMapping("/salas-controller")
public class SalasControlador {
    @Autowired
    private SalaInterfaz salaInterfaz;

    @GetMapping("/get-sala")
    public ResponseEntity<ObjectResponse> getSala(){
        return ResponseEntity.ok(salaInterfaz.getSala());
    }

    @GetMapping("/get-sala-disponible")
    public ResponseEntity<ObjectResponse> getSalaDisponible(){
        return ResponseEntity.ok(salaInterfaz.getSalaDisponible());
    }

    @GetMapping("/get-sala-disponible-profesor")
    public ResponseEntity<ObjectResponse> getSalaDisponibleProfesor(){
        return ResponseEntity.ok(salaInterfaz.getSalaDisponibleProfesor());
    }

    @GetMapping("/get-equipo-by-idsala")
    public ResponseEntity<ObjectResponse> getEquipoByIdsala(@RequestParam Integer idsala){
        return ResponseEntity.ok(salaInterfaz.getEquipoByIdsala(idsala));
    }

    @GetMapping("/get-facultad")
    public ResponseEntity<ObjectResponse> getFacultad(){
        return ResponseEntity.ok(salaInterfaz.getFacultad());
    }

    @GetMapping("/get-programa-by-idfacultad")
    public ResponseEntity<ObjectResponse> getProgrmaByIdfacultad(@RequestParam Integer idfacultad){
        return ResponseEntity.ok(salaInterfaz.getProgramaByIdfacultad(idfacultad));
    }
    @GetMapping("/get-programa")
    public ResponseEntity<ObjectResponse> getProgrma(){
        return ResponseEntity.ok(salaInterfaz.getPrograma());
    }
    @GetMapping("/get-curso-by-idprograma")
    public ResponseEntity<ObjectResponse> getCursoByIdprograma(@RequestParam Integer idprograma){
        return ResponseEntity.ok(salaInterfaz.getCursoByIdprograma(idprograma));
    }

    @GetMapping("/get-estudiante-by-documento")
    public ResponseEntity<ObjectResponse> getEstudianteByDocumento(@RequestParam String documento){
        return ResponseEntity.ok(salaInterfaz.getEstudianteByDocumento(documento));
    }

    @GetMapping("/get-profesor")
    public ResponseEntity<ObjectResponse> getProfesor(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "cedula", required = false) String cedula){
        return ResponseEntity.ok(salaInterfaz.getProfesorByIdProfesorByCedula(id,cedula));
    }

    @GetMapping("/get-invitado-by-identificacion")
    public ResponseEntity<ObjectResponse> getInvitadoByIdentificacion(@RequestParam String identificacion){
        return ResponseEntity.ok(salaInterfaz.getInvitadoByIdentificacion(identificacion));
    }

    @PostMapping("/save-invitado")
    public ResponseEntity<ObjectResponse> saveInvitado(@RequestBody InvitadoDto invitadoDto){
        return ResponseEntity.ok(salaInterfaz.saveInvitado(invitadoDto));
    }

    @PostMapping("/save-registrosala")
    public ResponseEntity<ObjectResponse> saveRegistroSala(@RequestBody RegistroSalaEntidad registroSalaEntidad){
        return ResponseEntity.ok(salaInterfaz.saveRegistroSala(registroSalaEntidad));
    }

    @PostMapping("/save-registroestudiante")
    public ResponseEntity<ObjectResponse> saveRegistroEstudiante(@RequestBody RegistroEstudianteEntidad registroEstudianteEntidad){
        return ResponseEntity.ok(salaInterfaz.saveRegistroEstudiante(registroEstudianteEntidad));
    }

    @GetMapping("/get-reporte")
    public ResponseEntity<ObjectResponse> getDatosReporte(){
        return ResponseEntity.ok(salaInterfaz.getDatosReporte());
    }

    @PostMapping("/save-estudiante")
    public ResponseEntity<ObjectResponse> saveEstudiante(@RequestBody EstudianteEntidad estudianteEntidad){
        return ResponseEntity.ok(salaInterfaz.saveEstudiante(estudianteEntidad));
    }

    @GetMapping("/get-semestre")
    public ResponseEntity<ObjectResponse> getSemestre(){
        return ResponseEntity.ok(salaInterfaz.getSemetre());
    }

    @GetMapping("/get-jornada")
    public ResponseEntity<ObjectResponse> getJornada(){
        return ResponseEntity.ok(salaInterfaz.getJornada());
    }

    @PostMapping("/save-estudiante-lista")
    public ResponseEntity<ObjectResponse> saveEstudianteList(@RequestBody List<EstudianteEntidad> estudianteEntidadList){
        return ResponseEntity.ok(salaInterfaz.saveEstudianteList(estudianteEntidadList));
    }

    @GetMapping("/get-ubicacion")
    public ResponseEntity<ObjectResponse> getUbicaion(){
        return ResponseEntity.ok(salaInterfaz.getUbicacion());
    }


    @GetMapping("/get-usuario-by-documento")
    public ResponseEntity<ObjectResponse> getUsuarioByDocumento(@RequestParam String documento){
        return ResponseEntity.ok(salaInterfaz.getUsuarioByDocumento(documento));
    }

    @PostMapping("/save-registro-portatil/{idmomento}")
    public ResponseEntity<ObjectResponse> saveRegistroPortatil(@PathVariable("idmomento") Integer idMomento, @RequestBody RegistroPortatilEntidad registroPortatilEntidad){
        return ResponseEntity.ok(salaInterfaz.saveRegistroPortatil(registroPortatilEntidad, idMomento));
    }

    @GetMapping("/get-solicitudes-pendientes")
    public ResponseEntity<ObjectResponse> getSolicitudesPendientes(){
        return ResponseEntity.ok(salaInterfaz.getSolicitudesPendientes());
    }
    @GetMapping("/get-equipo-portatil-disponible")
    public ResponseEntity<ObjectResponse> getEquipoPortatilDisponible(){
        return ResponseEntity.ok(salaInterfaz.getEquipoPortatilDisponible());
    }

    @GetMapping("/get-equipo-portatil-sin-devolver")
    public ResponseEntity<ObjectResponse> getEquipoPortatilSinDevolver(){
        return ResponseEntity.ok(salaInterfaz.getEquipoPortatilSinDevolver());
    }

    @GetMapping("/get-usuario-lista-negra")
    public ResponseEntity<ObjectResponse> getUsuarioListaNegra(){
        return ResponseEntity.ok(salaInterfaz.getUsuarioListaNegra());
    }
}
