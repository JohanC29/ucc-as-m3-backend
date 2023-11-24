package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.SalaEntidad;

import java.util.Date;
import java.util.List;

@Repository
public interface SalaRepositorio extends JpaRepository<SalaEntidad, Integer> {

    @Query(value = "SELECT s.id, s.descripcion FROM sala s, registrosala rs WHERE s.id = rs.idsala and :FECHA_ACTUAL BETWEEN rs.fechainicial and rs.fechafinal GROUP BY s.id, s.descripcion", nativeQuery = true)
    List<SalaEntidad> getSalaDisponible(@Param("FECHA_ACTUAL")Date fechaActual);


    @Query(value = "SELECT s.id, s.descripcion FROM sala s WHERE  not EXISTS ( select 'x' from registrosala rs where s.id = rs.idsala and :FECHA_ACTUAL BETWEEN rs.fechainicial and rs.fechafinal ) GROUP BY s.id, s.descripcion ", nativeQuery = true)
    List<SalaEntidad> getSalaDisponibleProfesor(@Param("FECHA_ACTUAL")Date fechaActual);
}
