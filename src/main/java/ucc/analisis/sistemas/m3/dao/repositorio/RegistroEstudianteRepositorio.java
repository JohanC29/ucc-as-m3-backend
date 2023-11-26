package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroEstudianteEntidad;

import java.util.List;
import java.util.Map;

@Repository
public interface RegistroEstudianteRepositorio extends JpaRepository<RegistroEstudianteEntidad, Integer> {

    @Query(value = """
    SELECT 
        re.id AS RegistroEstudianteID,
        DATE_FORMAT(re.fechacreacion, '%d-%m-%Y %H:%i:%S') AS RegistroEstudianteFechaCreacion,
        e.documento AS EstudianteDocumento,
        e.nombre AS EstudianteNombre,
        e.apellido AS EstudianteApellido,
        e.estado AS EstudianteEstado,
        p2.descripcion AS ProgramaEstudianteDescripcion,
        i.identificacion AS InvitadoIdentificacion,
        i.nombre AS InvitadoNombre,
        i.apellido AS InvitadoApellido,
        p3.descripcion AS ProgramaInvitadoDescripcion,
        e2.descripcion AS EquipoDescripcion,
        DATE_FORMAT(rs.fechainicial, '%d-%m-%Y %H:%i:%S') AS RegistroSalaFechaInicial,
        DATE_FORMAT(rs.fechafinal, '%d-%m-%Y %H:%i:%S') AS RegistroSalaFechaFinal,
        DATE_FORMAT(rs.fechacreacion, '%d-%m-%Y %H:%i:%S') AS RegistroSalaFechaCreacion,
        s.descripcion AS SalaDescripcion,
        p.nombre AS ProfesorNombre,
        p.apellido AS ProfesorApellido,
        p.cedula AS ProfesorCedula,
        f.descripcion AS FacultadDescripcion,
        c.descripcion AS CursoDescripcion
    FROM
        registroestudiante re 
        LEFT JOIN estudiante e ON re.idestudiante = e.id 
        LEFT JOIN programa p2 ON e.idprograma = p2.id
        LEFT JOIN invitado i ON re.idinvitado = i.id 
        LEFT JOIN programa p3 ON i.idprograma = p3.id
        LEFT JOIN equipo e2 ON re.idequipo = e2.id 
        INNER JOIN registrosala rs ON rs.id = re.idregistrosala 
        INNER JOIN sala s ON s.id = rs.idsala 
        INNER JOIN profesor p ON p.id = rs.idprofesor 
        INNER JOIN facultad f ON f.id = rs.idfacultad 
        INNER JOIN curso c ON c.id = rs.idcurso;
        """, nativeQuery = true)
    List<Map<String,String>> obtenerDatosCompletos();
}
