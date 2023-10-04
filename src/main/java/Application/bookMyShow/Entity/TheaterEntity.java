package Application.bookMyShow.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Theater")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    // parent relation to theaterSeatEntity
    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    // here we're recording all the seats we booked while booking the ticket
    private List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

    // parent relation to theaterEntity
    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();


}
