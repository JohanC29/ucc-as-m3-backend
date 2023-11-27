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
    END AS rol
FROM registroportatil r
left join estudiante e
on r.idestudiante = e.id
LEFT join profesor p
on r.idprofesor = p.id
LEFT JOIN funcionario f
on r.idfuncionario = f.id
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
}
