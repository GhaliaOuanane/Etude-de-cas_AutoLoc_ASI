package tn.esprit.autoloc.autolocapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.Repository.IAgenceRepository;
import tn.esprit.autoloc.autolocapi.domain.Agence;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;

    @Override
    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence addAgence(Agence a) {
        return agenceRepository.save(a);
    }

    @Override
    public Agence updateAgence(Agence a) {
        return agenceRepository.save(a);
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence non trouvée avec l'id: " + idAgence));
    }

    @Override
    public void removeAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    @Override
    public List<Agence> addAgences(List<Agence> agences) {
        return agenceRepository.saveAll(agences);
    }
}
