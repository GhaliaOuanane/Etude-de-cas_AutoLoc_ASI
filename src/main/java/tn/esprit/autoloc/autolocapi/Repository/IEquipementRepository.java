package tn.esprit.autoloc.autolocapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.autolocapi.domain.Equipement;

public interface IEquipementRepository extends JpaRepository<Equipement, Long> {
}
