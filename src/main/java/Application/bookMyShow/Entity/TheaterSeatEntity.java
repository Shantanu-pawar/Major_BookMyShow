package Application.bookMyShow.Entity;

import Application.bookMyShow.Enums.SeatTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Theater seats")
@Data
@AllArgsConstructor
@Builder
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SeatTypes seatTypes;

    private String seatNo;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;
}
