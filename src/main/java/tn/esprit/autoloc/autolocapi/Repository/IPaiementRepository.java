package tn.esprit.autoloc.autolocapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.autolocapi.domain.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {
}
