package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.CursoEntidad;

import java.util.List;

@Repository
public interface CursoRepositorio extends JpaRepository<CursoEntidad, Integer> {

    List<CursoEntidad> findByIdprograma(Integer idprograma);
}
