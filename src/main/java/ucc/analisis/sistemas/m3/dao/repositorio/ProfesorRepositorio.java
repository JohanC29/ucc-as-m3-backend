package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.ProfesorEntidad;

@Repository
public interface ProfesorRepositorio extends JpaRepository<ProfesorEntidad, Integer>, JpaSpecificationExecutor<ProfesorEntidad> {

}
