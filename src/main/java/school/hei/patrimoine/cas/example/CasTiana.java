package school.hei.patrimoine.cas.example;

import static java.time.Month.*;
import static school.hei.patrimoine.modele.Argent.ariary;
import static school.hei.patrimoine.modele.Devise.MGA;

import java.time.LocalDate;
import java.util.Set;
import school.hei.patrimoine.cas.Cas;
import school.hei.patrimoine.modele.Devise;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.Compte;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Materiel;
import school.hei.patrimoine.modele.possession.Possession;

public class CasTiana extends Cas {

    private final Compte compte;

    public CasTiana() {
        super(LocalDate.of(2026, MARCH, 31), LocalDate.of(2026, MARCH, 31), new Personne("Tiana"));
        compte = new Compte("Compte bancaire principal", LocalDate.MIN, ariary(60_000_000));
    }

    @Override
    protected String nom() {
        return "Tiana";
    }

    @Override
    protected Devise devise() {
        return MGA;
    }

    @Override
    protected void init() {}

    @Override
    public Set<Possession> possessions() {
        var aujourdHui = LocalDate.of(2025, APRIL, 8);

        // Dépenses de vie mensuelles
        var depenseVie = new FluxArgent(
                "Dépenses mensuelles",
                compte,
                LocalDate.of(2025, APRIL, 30),
                LocalDate.of(2026, MARCH, 30),
                12,
                ariary(-4_000_000));

        // Dépenses projet entrepreneurial
        var depenseProjet = new FluxArgent(
                "Dépenses projet (1 juin - 31 décembre)",
                compte,
                LocalDate.of(2025, JUNE, 5),
                LocalDate.of(2025, DECEMBER, 5),
                7,
                ariary(-5_000_000));

        // Revenus projet entrepreneurial
        var revenuProjet1 = new FluxArgent(
                "Revenu projet - 10%",
                compte,
                LocalDate.of(2025, MAY, 1),
                LocalDate.of(2025, MAY, 1),
                1,
                ariary(7_000_000));

        var revenuProjet2 = new FluxArgent(
                "Revenu projet - 90%",
                compte,
                LocalDate.of(2026, JANUARY, 31),
                LocalDate.of(2026, JANUARY, 31),
                1,
                ariary(63_000_000));

        // Prêt reçu
        var pret = new FluxArgent(
                "Prêt bancaire",
                compte,
                LocalDate.of(2025, JULY, 27),
                LocalDate.of(2025, JULY, 27),
                1,
                ariary(20_000_000));

        // Remboursement du prêt
        var remboursementPret = new FluxArgent(
                "Mensualité de prêt",
                compte,
                LocalDate.of(2025, AUGUST, 27),
                LocalDate.of(2026, JULY, 27),
                12,
                ariary(-2_000_000));

        // Valeur du terrain avec appréciation
        var terrain = new Materiel(
                "Terrain bâti",
                aujourdHui,
                LocalDate.of(2026, MARCH, 31),
                ariary(100_000_000),
                0.10); // appréciation annuelle de 10%

        return Set.of(
                compte,
                depenseVie,
                depenseProjet,
                revenuProjet1,
                revenuProjet2,
                pret,
                remboursementPret,
                terrain
        );
    }

    @Override
    protected void suivi() {}
}
