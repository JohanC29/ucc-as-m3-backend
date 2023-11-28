package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.RegistroPortatilEntidad;


import java.util.List;
import java.util.Map;

@Repository
public interface RegistroPortatilRepositorio extends JpaRepository<RegistroPortatilEntidad, Integer> {

    @Query(value = """
SELECT r.*,   
COALESCE(e.documento, p.cedula, f.documento) AS documento,
COALESCE(e.nombre, p.nombre, f.nombre) AS nombre,
COALESCE(e.apellido, p.apellido, f.apellido) AS apellido,
    CASE
        WHEN e.id IS NOT NULL THEN 'ESTUDIANTE'
        WHEN p.id IS NOT NULL THEN 'PROFESOR'
        WHEN f.id IS NOT NULL THEN 'FUNCIONARIO'
    END AS rol,
    case  WHEN u.id IS NOT NULL then 'SI' else 'NO' end  bloqueado
FROM registroportatil r
left join estudiante e
on r.idestudiante = e.id
LEFT join profesor p
on r.idprofesor = p.id
LEFT JOIN funcionario f
on r.idfuncionario = f.id
LEFT JOIN usuariolistanegra u
on e.id = u.idestudiante or  p.id  = u.idprofesor or f.id = u.idfuncionario
WHERE r.idequipo IS NULL AND r.fechaasigna IS NULL
""", nativeQuery = true)
    List<Map<String,String>> findRegistroPortatilSinEquipoYFechaAsigna();

    @Query(value =
            """
SELECT r.*,    
COALESCE(e.documento, p.cedula, f.documento) AS documento,
COALESCE(e.nombre, p.nombre, f.nombre) AS nombre,
COALESCE(e.apellido, p.apellido, f.apellido) AS apellido,
    CASE
        WHEN e.id IS NOT NULL THEN 'ESTUDIANTE'
        WHEN p.id IS NOT NULL THEN 'PROFESOR'
        WHEN f.id IS NOT NULL THEN 'FUNCIONARIO'
    END AS rol
FROM registroportatil r
left join estudiante e
on r.idestudiante = e.id
LEFT join profesor p
on r.idprofesor = p.id
LEFT JOIN funcionario f
on r.idfuncionario = f.id
WHERE r.idequipo IS not NULL AND r.fecharegreso IS NULL
""", nativeQuery = true)
    List<Map<String,String>> findRegistroPortatilSinDevolver();



    @Query(value = """
SELECT
    r.id,
    r.idfuncionario,
    f.documento AS documento_funcionario,
    f.nombre AS nombre_funcionario,
    f.apellido AS apellido_funcionario,
    f.iddependencia,
    f.estado AS estado_funcionario,
    r.idestudiante,
    e.documento AS documento_estudiante,
    e.nombre AS nombre_estudiante,
    e.apellido AS apellido_estudiante,
    e.idprograma,
    e.idsemestre,
    e.idjornada,
    e.estado AS estado_estudiante,
    r.idprofesor,
    p.nombre AS nombre_profesor,
    p.apellido AS apellido_profesor,
    p.cedula AS cedula_profesor,
    p.estado AS estado_profesor,
    r.celular,
    r.fechasolicitud,
    r.idequipo,
    r.usuarioasigna,
    r.fechaasigna,
    r.fecharegreso,
    prog.descripcion AS descripcion_programa,
    prog.idfacultad,
    CASE
        WHEN e.id IS NOT NULL THEN 'ESTUDIANTE'
        WHEN p.id IS NOT NULL THEN 'PROFESOR'
        WHEN f.id IS NOT NULL THEN 'FUNCIONARIO'
    END AS rol
FROM\s
    registroportatil r
    LEFT JOIN funcionario f ON r.idfuncionario = f.id
    LEFT JOIN estudiante e ON r.idestudiante = e.id
    LEFT JOIN profesor p ON r.idprofesor = p.id
    LEFT JOIN programa prog ON e.idprograma = prog.id
    """, nativeQuery = true)
    List<Map<String,String>> reporteModuloPortatiles();
}
