package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.EstudianteEntidad;

import java.util.List;

@Repository
public interface EstudianteRepositorio extends JpaRepository<EstudianteEntidad, Integer> {

    List<EstudianteEntidad> findByDocumento(String documento);
}
