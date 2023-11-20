package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.SemestreEntidad;

@Repository
public interface SemestreRepositorio extends JpaRepository<SemestreEntidad, Integer> {

}
