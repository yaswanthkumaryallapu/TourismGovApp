package com.cognizant.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.site.entity.PreservationActivity;
import com.cognizant.site.enums.PreservationStatus;

@Repository
public interface PreservationActivityRepository extends JpaRepository<PreservationActivity, Long> {
    
    // 'site' is still a @ManyToOne in this microservice
    List<PreservationActivity> findBySite_SiteId(Long siteId);

    // CHANGED: 'officer' is now a flat 'officerId' Long. No underscore needed.
    List<PreservationActivity> findByOfficerId(Long officerId);

    // CHANGED: Uses PreservationStatus Enum (Removed IgnoreCase)
    List<PreservationActivity> findByStatus(PreservationStatus status);
}