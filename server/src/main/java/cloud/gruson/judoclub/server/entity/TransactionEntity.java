package cloud.gruson.judoclub.server.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class TransactionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_id")
    @SequenceGenerator(name = "club_id", sequenceName = "club_id", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    private double amount;

    private String description;

    private String method;

    private TransactionTypeEntity type;

    public enum TransactionTypeEntity {
        PAYMENT, DUE, DISCOUNT;
    }

}
