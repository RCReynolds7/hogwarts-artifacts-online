package edu.tcu.cs.hogwartsartifactsonline.artifact;

import  org.mockito.Mockito.times;


import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import  org.mockito.Mockito.Verify;

import edu.tcu.cs.hogwartsartifactsonline.wizard.wizard;

@ExtendWith(MockitoExtension.class)
public class ArtifactServiceTest {

    @Mock
    ArtifactRepository artifactRepository;

    @InjectMocks
    ArtifactService artifactService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testFindByIdSuccess() {
        // Given. Arrange inputs and targets. Define the behavior of the mock object artifactRepository 
        /*
          "id": "1250808601744904192",
         "name": "Invisibility Cloak",
        "description": "An invisibility cloak is used to make the wearer invisible.",
        "imageUrl": "ImageUrl",
         */
        Artifact a = new Artifact();

        a.setId("1250808601744904192");
        a.setName("Invisibility Cloak");
        a.setDescription("An invisibility cloak is used to make the wearer invisible");
        a.setImageurl("ImageUrl");

        wizard w = new Wizard();
        w.setId(2);
        w.setName("Harry Potter");
        
        a.setOwner(w);

        given(artifactRepository.findById("1250808601744904192")).willReturn(Optional.of.a)); //Defines the behavoir of the mock object
        // When. Act on the target behavoir. When stps should cover the method to be tested
        Artifact returnedArtifact = artifactService.findById("1250808601744904192");
        // Then. Assert expected outcomes. 
        assertThat(returnedArtifact.getId()).isEqualTo(a.getId());
        assertThat(returnedArtifact.getName()).isEqualTo(a.getName());
        assertThat(returnedArtifact.getDescription()).isEqualTo(a.getDescription());
        assertThat(returnedArtifact.getImageurl()).isEqualTo(a.getImageurl());
        verify(artifactRepository, times(1)).findById("1250808601744904192");
    }

    @Test
    void findByIdNotFound(){
        // Given
        given(artifactRepository.findById(Mockito.any(String.class))).willReturn(Optional.empty());

        // When 
        Throwable thrown = catchThrowable(()->{
            Artifact returnedArtifact = artifactService.findById("1250808601744904192");
        });

        // Then

        assertThat(thrown).isInstanceOf(ArtifactNotFoundException.class).hasMessage("Could not find artifact by id: 1250808601744904192");
                verify(artifactRepository, times(1)).findById("1250808601744904192");

    }   

}
