package com.profile.profile_service.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.profile.profile_service.entity.UserProfile;

@Repository
public interface UserProfileRepository extends Neo4jRepository<UserProfile, String> {}
