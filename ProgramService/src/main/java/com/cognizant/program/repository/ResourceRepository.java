package com.cognizant.program.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.program.entity.Resource;
import com.cognizant.program.enums.ResourceStatus;
import com.cognizant.program.enums.ResourceType;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    
    // 'program' is still a @ManyToOne in this microservice
    List<Resource> findByProgram_ProgramId(Long programId);

    // CHANGED: String type is now ResourceType enum
    List<Resource> findByProgram_ProgramIdAndType(Long programId, ResourceType type);

    // CHANGED: String status is now ResourceStatus enum
    List<Resource> findByStatus(ResourceStatus status);
}