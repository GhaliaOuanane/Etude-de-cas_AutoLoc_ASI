package tn.esprit.autoloc.autolocapi.domain;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String telephone;

    @Column(unique = true, nullable = false, length = 30)
    private String numPermis;

    @Column(nullable = false)
    private LocalDate dateInscription;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Reservation> reservations;
}

