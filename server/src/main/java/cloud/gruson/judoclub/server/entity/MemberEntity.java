package cloud.gruson.judoclub.server.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;
import java.time.LocalDate;

@Entity
public class MemberEntity {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String zipCode;

    private String country;

    private LocalDate birthDay;

    private String phoneNumber;

    private String email;

    private String comment;

}
