package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.InvitadoEntidad;

import java.util.List;

@Repository
public interface InvitadoRepositorio extends JpaRepository<InvitadoEntidad, Integer> {
    List<InvitadoEntidad> findByIdentificacion(String identificacion);
}
