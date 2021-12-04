package cloud.gruson.judoclub.server.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class JudokaEntity extends MemberEntity {

    private double weigth;

    private LocalDate registerDate;

    private boolean medicalCert;

    private boolean license;

    private boolean personalCoverage;

    @ManyToOne
    private BeltEntity currentBelt;

    @ManyToMany
    private List<ClubEntity> clubs;

    @ManyToMany
    private List<ClasseEntity> classes;

    @OneToMany
    private List<TransactionEntity> transactionEntities;

    private double balance;

}
