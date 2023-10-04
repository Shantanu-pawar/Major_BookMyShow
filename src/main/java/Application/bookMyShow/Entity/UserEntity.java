package Application.bookMyShow.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@Builder
public class UserEntity {
/* note : so when we're creating DTO so for that builder anotation is needed [@AllArgs constructor is mandatory for that]*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;

    @NonNull // this also refers like nullable
    @Column(unique = true)
    private String mobNo;
    private String address;

    // parent wrt to ticket
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntityList = new ArrayList<>();


    // after adding @Data annotation but we still have to add constructors.
    public UserEntity(String name, String email, int age, String mobNo, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.mobNo = mobNo;
        this.address = address;
    }

    public UserEntity() {
    }
}
