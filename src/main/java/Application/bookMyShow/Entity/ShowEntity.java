package Application.bookMyShow.Entity;

import Application.bookMyShow.Enums.ShowTypes;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Data
@Table(name = "shows")
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate; // we are using localDate class to timestamp current date

    private LocalTime showTime; // local time

    @Enumerated(value = EnumType.STRING)
    private ShowTypes showTypes;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


    // this is parent wrt to ticketEntity
    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    List<TicketEntity> ticketEntityList = new ArrayList<>();

    // this is child wrt to movieEntity
    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;

    // this is child wrt to theaterEntity
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

//    this is parent wrt to showSeatEntity
    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    private List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();
}
