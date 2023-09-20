package Application.bookMyShow.Entity;

import Application.bookMyShow.Enums.SeatTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "show seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked;

    private int price; // this is price of that recliner or classic seat perticular
    private String seatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatTypes seatTypes;

    private Date bookedAt;

    // this is child wrt to showEntity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
}
