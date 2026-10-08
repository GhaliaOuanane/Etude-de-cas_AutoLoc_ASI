package tn.esprit.autoloc.autolocapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.autolocapi.domain.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {
}
