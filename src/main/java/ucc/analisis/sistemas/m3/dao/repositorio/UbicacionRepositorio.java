package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.UbicacionEntidad;

@Repository
public interface UbicacionRepositorio extends JpaRepository<UbicacionEntidad, Integer> {
}
