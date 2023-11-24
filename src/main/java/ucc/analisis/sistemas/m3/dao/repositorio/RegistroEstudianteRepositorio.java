package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroEstudianteEntidad;

import java.util.List;
import java.util.Map;

@Repository
public interface RegistroEstudianteRepositorio extends JpaRepository<RegistroEstudianteEntidad, Integer> {

    @Query(value = "SELECT \n" +
            "    re.id AS RegistroEstudianteID,\n" +
            "    re.idregistrosala AS RegistroSalaID,\n" +
            "    re.idestudiante AS EstudianteID,\n" +
            "    re.idequipo AS EquipoID,\n" +
            "    re.idinvitado AS InvitadoID,\n" +
            "    re.fechacreacion AS RegistroEstudianteFechaCreacion,\n" +
            "    e.id AS EstudianteID,\n" +
            "    e.documento AS EstudianteDocumento,\n" +
            "    e.nombre AS EstudianteNombre,\n" +
            "    e.apellido AS EstudianteApellido,\n" +
            "    e.idprograma AS EstudianteProgramaID,\n" +
            "    e.idsemestre AS EstudianteSemestreID,\n" +
            "    e.idjornada AS EstudianteJornadaID,\n" +
            "    e.estado AS EstudianteEstado,\n" +
            "    i.id AS InvitadoID,\n" +
            "    i.identificacion AS InvitadoIdentificacion,\n" +
            "    i.nombre AS InvitadoNombre,\n" +
            "    i.apellido AS InvitadoApellido,\n" +
            "    i.idprograma AS InvitadoProgramaID,\n" +
            "    e2.id AS EquipoID,\n" +
            "    e2.descripcion AS EquipoDescripcion,\n" +
            "    rs.id AS RegistroSalaID,\n" +
            "    rs.idsala AS SalaID,\n" +
            "    rs.idprofesor AS ProfesorID,\n" +
            "    rs.fechainicial AS RegistroSalaFechaInicial,\n" +
            "    rs.fechafinal AS RegistroSalaFechaFinal,\n" +
            "    rs.idfacultad AS FacultadID,\n" +
            "    rs.idcurso AS CursoID,\n" +
            "    rs.fechacreacion AS RegistroSalaFechaCreacion,\n" +
            "    p.id AS ProfesorID,\n" +
            "    p.nombre AS ProfesorNombre,\n" +
            "    p.apellido AS ProfesorApellido,\n" +
            "    p.cedula AS ProfesorCedula,\n" +
            "    p.estado AS ProfesorEstado,\n" +
            "    f.id AS FacultadID,\n" +
            "    f.descripcion AS FacultadDescripcion,\n" +
            "    c.id AS CursoID,\n" +
            "    c.descripcion AS CursoDescripcion,\n" +
            "    c.idprograma AS CursoProgramaID,\n" +
            "    s.id AS SalaID,\n" +
            "    s.descripcion AS SalaDescripcion,\n" +
            "    p2.id AS ProgramaID,\n" +
            "    p2.descripcion AS ProgramaDescripcion\n" +
            "from registroestudiante re \n" +
            "left join estudiante e on re.idestudiante = e.id \n" +
            "left join invitado i on re.idinvitado = i.id \n" +
            "left join equipo e2 on re.idequipo = e2.id \n" +
            "inner join registrosala rs on rs.id = re.idregistrosala \n" +
            "inner join profesor p on p.id = rs.idprofesor \n" +
            "inner join facultad f on f.id = rs.idfacultad \n" +
            "inner join curso c on c.id = rs.idcurso \n" +
            "inner join sala s on s.id = rs.idsala \n" +
            "inner join programa p2 on p2.id = c.idprograma;", nativeQuery = true)
    List<Map<String,String>> obtenerDatosCompletos();
}
