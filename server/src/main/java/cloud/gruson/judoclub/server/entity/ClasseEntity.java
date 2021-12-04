package cloud.gruson.judoclub.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class ClasseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classe_id")
    @SequenceGenerator(name = "classe_id", sequenceName = "classe_id", allocationSize = 1)
    private Long id;

    private String day;

    private String hour;

    private String category;
    
}
