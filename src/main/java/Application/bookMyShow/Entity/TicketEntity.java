package Application.bookMyShow.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;

    private LocalDate showDate;
    private LocalTime showTime;

    private int totalAmount;

    // here we created random UUID for tickets
    private String ticketID = UUID.randomUUID().toString();

    private String theaterName;


    // this is child wrt to user
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    // this is child wrt to showEntity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
}
