package cloud.gruson.judoclub.server.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_id")
    @SequenceGenerator(name = "club_id", sequenceName = "club_id", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    private List<ClasseEntity> classes;
    
}
