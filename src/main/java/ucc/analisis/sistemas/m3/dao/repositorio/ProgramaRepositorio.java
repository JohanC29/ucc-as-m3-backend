package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.ProgramaEntidad;

import java.util.List;

@Repository
public interface ProgramaRepositorio extends JpaRepository<ProgramaEntidad, Integer> {

    List<ProgramaEntidad> findByIdfacultad(Integer idfacultad);
}
