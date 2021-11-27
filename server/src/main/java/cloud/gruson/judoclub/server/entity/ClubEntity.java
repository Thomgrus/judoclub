package cloud.gruson.judoclub.server.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class ClubEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String name;
    
}
