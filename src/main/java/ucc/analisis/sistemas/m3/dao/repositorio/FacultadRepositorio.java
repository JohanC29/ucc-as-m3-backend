package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.FacultadEntidad;

@Repository
public interface FacultadRepositorio extends JpaRepository<FacultadEntidad, Integer> {
}
