package com.cognizant.event.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.event.entity.Booking;
import com.cognizant.event.enums.BookingStatus;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    // 'event' is still a @ManyToOne in this microservice, so underscore is correct
    List<Booking> findByEvent_EventId(Long eventId);
    Page<Booking> findByEvent_EventId(Long eventId, Pageable pageable);
    
    // CHANGED: 'tourist' object is gone. It's now a flat 'touristId' Long field.
    List<Booking> findByTouristId(Long touristId);
    Page<Booking> findByTouristId(Long touristId, Pageable pageable);

    // CHANGED: Mixed approach. Event is object, Tourist is flat ID.
    boolean existsByEvent_EventIdAndTouristId(Long eventId, Long touristId);
    
    // Added: Filter by BookingStatus Enum
    List<Booking> findByStatus(BookingStatus status);
}