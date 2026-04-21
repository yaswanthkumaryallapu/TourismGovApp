package com.cognizant.tourist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.tourist.model.TouristDocument;

@Repository
public interface TouristDocumentRepository extends JpaRepository<TouristDocument, Long> {
	Optional<TouristDocument> findByDocumentIdAndTourist_TouristId(Long documentId, Long touristId);
}