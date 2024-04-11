package edu.tcu.cs.hogwartsartifactsonline.artifact;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtifactRepository extends JpaRepository<Artifact, String> {
}