package com.cognizant.event.entity;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Event{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(nullable = false)
    private String title;

    private String location;

    @Column(name = "event_date", nullable = false)
    private LocalDateTime date;

    @Column(nullable = false, length = 50)
    private String status;

    // Cross-service ID reference (Heritage Site Service)
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    // Cross-service ID reference (Tourism Program Service)
    @Column(name = "program_id")
    private Long programId;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Booking> bookings;
}