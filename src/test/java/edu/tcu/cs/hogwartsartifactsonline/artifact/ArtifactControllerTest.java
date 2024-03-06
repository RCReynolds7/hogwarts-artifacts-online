package edu.tcu.cs.hogwartsartifactsonline.artifact;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ArtifactControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean 
    ArtifactService artifactService;

    List<Artifact> artifact;
    
    @BeforeEach
    void setUp() {
        this.artifact = new ArrayList<>()

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findArtifactById() {

    }
}
