package ucc.analisis.sistemas.m3.dao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucc.analisis.sistemas.m3.dao.entidades.EquipoEntidad;

import java.util.List;

@Repository
public interface EquipoRepositorio extends JpaRepository<EquipoEntidad, Integer> {
    List<EquipoEntidad> findByIdsala(Integer idsala);

    @Query(value = """
            select * from equipo e 
            where e.idsala is null 
            and not EXISTS (select 'x' from registroportatil r where r.idequipo = e.id
            and r.fecharegreso is NULL);
            """, nativeQuery = true)
    List<EquipoEntidad> findEquipoPortatilDisponible();

}
