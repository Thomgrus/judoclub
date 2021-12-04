package cloud.gruson.judoclub.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class BeltEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "belt_id")
    @SequenceGenerator(name = "belt_id", sequenceName = "belt_id", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String color;

    private int dan;
}
