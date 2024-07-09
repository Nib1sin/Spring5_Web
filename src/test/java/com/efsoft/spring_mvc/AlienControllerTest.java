package com.efsoft.spring_mvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.efsoft.spring_mvc.model.Alien;
import com.efsoft.spring_mvc.repository.AlienRepository;


@ExtendWith(MockitoExtension.class)
public class AlienControllerTest {

	@Mock
    private AlienRepository alienRepository;

    @InjectMocks
    private AlienController alienController;

	@Test
    public void testGetAliens() throws Exception {
		
		// GIVEN
        Alien alien = new Alien();
        //when(alienRepository.getAliens()).thenReturn(List.of(alien));

        // WHEN
        List<Alien> result = alienController.getAliens();

        // THEN
        // No null
        assertNotNull(result);
        // Ensure the repository's findAll method was called
        //verify(alienRepository).findAll();
		
    }

}
