package tn.esprit.autoloc.autolocapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.autolocapi.domain.Contrat;

public interface IContratRepository extends JpaRepository<Contrat, Long> {
}
