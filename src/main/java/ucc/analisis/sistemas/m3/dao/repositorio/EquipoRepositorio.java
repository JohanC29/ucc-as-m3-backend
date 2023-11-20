package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.EquipoEntidad;

import java.util.List;

@Repository
public interface EquipoRepositorio extends JpaRepository<EquipoEntidad, Integer> {
    List<EquipoEntidad> findByIdsala(Integer idsala);
}
