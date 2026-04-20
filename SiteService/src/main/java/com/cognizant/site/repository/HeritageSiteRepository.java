package com.cognizant.site.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.site.entity.HeritageSite;
import com.cognizant.site.enums.SiteStatus;

@Repository
public interface HeritageSiteRepository extends JpaRepository<HeritageSite, Long> {

    boolean existsByNameIgnoreCase(String name);
    Optional<HeritageSite> findByName(String name);

    List<HeritageSite> findByLocationContainingIgnoreCase(String location);

    // CHANGED: Uses SiteStatus Enum
    List<HeritageSite> findByStatus(SiteStatus status);
}