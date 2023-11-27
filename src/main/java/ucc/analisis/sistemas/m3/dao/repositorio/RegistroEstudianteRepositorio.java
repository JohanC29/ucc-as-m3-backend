package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = """
            SELECT  x.id
           ,x.documento
           ,x.nombre
           ,x.apellido
           ,x.programa
           ,x.facultad
           ,x.semestre
           ,x.jornada
           ,x.dependencia
           ,x.rol
    FROM
    (
            SELECT  e.id id
    	       ,e.documento documento
    	       ,e.nombre nombre
    	       ,e.apellido apellido
    	       ,p.descripcion programa
    	       ,f.descripcion facultad
    	       ,s.descripcion semestre
    	       ,j.descripcion jornada
    	       ,'' dependencia
    	       ,'ESTUDIANTE' rol
    	FROM estudiante e, programa p , facultad f, semestre s , jornada j
            WHERE e.idprograma = p.id
    	AND p
            .idfacultad = f.id
            AND e.idsemestre = s.id
            AND e.idjornada = j.id
            UNION ALL
            SELECT  p.id id
    	       ,p.cedula documento
    	       ,p.nombre nombre
    	       ,p.apellido apellido
    	       ,'' programa
    	       ,'' facultad
    	       ,'' semestre
    	       ,'' jornada
    	       ,d.descripcion dependencia
    	       ,'PROFESOR' rol
    	FROM
            profesor p, dependencia d
            WHERE d.id = 1
            UNION ALL
    	SELECT  f.id id
    	       ,f.documento documento
    	       ,f.nombre nombre
    	       ,f.apellido apellido
    	       ,'' programa
    	       ,'' facultad
    	       ,'' semestre
    	       ,'' jornada
    	       ,d.descripcion dependencia
    	       ,'FUNCIONARIO' rol
    	FROM
            funcionario f, dependencia d
            WHERE f.iddependencia = d.id
    ) x
            WHERE x.documento = :DOCUMENTO
    ;""", nativeQuery = true)
    List<Map<String, String>> obtenerDatosUsuarios(@Param("DOCUMENTO")String documento);
}
