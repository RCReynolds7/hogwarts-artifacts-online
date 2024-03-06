package edu.tcu.cs.hogwartsartifactsonline.artifact;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArtifactService {

    private final ArtifactRepository artifactRepository;

    public ArtifactService(ArtifactRepository artifactRepository) {
        this.artifactRepository = artifactRepository;
    }

    public Artifact findById(String artifactId) {
        return this.artifactRepository.findById(artifactId).orElseThrow(()->new ArtfactNotFoundException(artifactId));
    }

}