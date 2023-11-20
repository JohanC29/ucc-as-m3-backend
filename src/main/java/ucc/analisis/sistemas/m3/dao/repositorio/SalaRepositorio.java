package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.SalaEntidad;

import java.util.List;

@Repository
public interface SalaRepositorio extends JpaRepository<SalaEntidad, Integer> {

    @Query(value = "SELECT s.id, s.descripcion FROM SALA s, REGISTROSALA rs WHERE s.id = rs.idsala and now() BETWEEN rs.fechainicial and rs.fechafinal GROUP BY s.id, s.descripcion", nativeQuery = true)
    List<SalaEntidad> getSalaDisponible();
}
