package tn.esprit.autoloc.autolocapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.autolocapi.domain.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
