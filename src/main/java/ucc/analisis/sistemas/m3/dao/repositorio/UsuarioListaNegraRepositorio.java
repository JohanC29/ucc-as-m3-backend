package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.UsuarioListaNegraEntidad;

import java.util.List;
import java.util.Map;

@Repository
public interface UsuarioListaNegraRepositorio extends JpaRepository<UsuarioListaNegraEntidad, Integer> {
    @Query(value = """
    SELECT  u.id
           ,f.documento
           ,f.nombre
           ,f.apellido
           ,'FUNCIONARIO' rol
    FROM usuariolistanegra u , funcionario f
    WHERE u.idfuncionario = f.id\s
    UNION ALL
    SELECT  u.id
           ,p.cedula documento
           ,p.nombre
           ,p.apellido
           ,'PROFESOR' rol
    FROM usuariolistanegra u , profesor p
    WHERE u.idprofesor = p.id\s
    UNION ALL
    SELECT  u.id
           ,e.documento
           ,e.nombre
           ,e.apellido
           ,'ESTUDIANTE' rol
    FROM usuariolistanegra u , estudiante e
    WHERE u.idestudiante = e.id
    ;
    """, nativeQuery = true)
    List<Map<String,String>>findAllUsuariosBloqueados();

}
