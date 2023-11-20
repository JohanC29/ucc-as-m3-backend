package ucc.analisis.sistemas.m3.dao.especificacion;


import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ucc.analisis.sistemas.m3.dao.entidades.ProfesorEntidad;

import java.util.ArrayList;
import java.util.List;

public class ProfesorEspecificacion {

    private ProfesorEspecificacion() {
        throw new IllegalStateException("Utility class");
    }
    public static Specification<ProfesorEntidad> findByIdProfesorOrCedula(Integer idprofesor, String cedula) {
        return Specification.where((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (idprofesor != null) {
                predicates.add(cb.equal(root.get("id"), idprofesor));
            }
            if (cedula != null) {
                predicates.add(cb.equal(root.get("cedula"), cedula));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}
