package tn.esprit.autoloc.autolocapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.Repository.IPaiementRepository;
import tn.esprit.autoloc.autolocapi.domain.Paiement;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement p) {
        return paiementRepository.save(p);
    }

    @Override
    public Paiement updatePaiement(Paiement p) {
        return paiementRepository.save(p);
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return paiementRepository.findById(idPaiement)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec l'id: " + idPaiement));
    }

    @Override
    public void removePaiement(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> paiements) {
        return paiementRepository.saveAll(paiements);
    }
}
