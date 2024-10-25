package org.toure.TestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.toure.Model.Tournoi;
import org.toure.Repository.interfaces.TournoiRepository;
import org.toure.Service.TournoiService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TournoiServiceTest {

    private TournoiRepository tournoiRepository;
    private TournoiService tournoiService;

    @BeforeEach
    public void setUp() {
        tournoiRepository = Mockito.mock(TournoiRepository.class);
        tournoiService = new TournoiService(tournoiRepository);
    }

    @Test
    public void testGetTournoi() {
        // Arrange
        long tournoiId = 1L;
        Tournoi tournoi = new Tournoi();
        tournoi.setId(tournoiId);
        // Simulez le comportement de la méthode findById
        when(tournoiRepository.findById(tournoiId)).thenReturn(tournoi);

        // Act
        Tournoi result = tournoiService.getTournoi(tournoiId);

        // Assert
        assertNotNull(result);
        assertEquals(tournoiId, result.getId());
        verify(tournoiRepository).findById(tournoiId); // Vérifiez que la méthode a été appelée
    }

    @Test
    public void testAjouterTournoi() {
        // Arrange
        Tournoi tournoi = new Tournoi();

        // Act
        tournoiService.ajouterTournoi(tournoi);

        // Assert
        verify(tournoiRepository).create(tournoi); // Vérifiez que la méthode create a été appelée
    }

    @Test
    public void testModifierTournoi() {
        // Arrange
        long tournoiId = 1L;
        Tournoi tournoi = new Tournoi();

        // Act
        tournoiService.ModifierTournoi(tournoi, tournoiId);

        // Assert
        verify(tournoiRepository).update(tournoi, tournoiId); // Vérifiez que la méthode update a été appelée
    }

    @Test
    public void testSupprimerTournoi() {
        // Arrange
        long tournoiId = 1L;

        // Act
        tournoiService.SuppremeTouroi(tournoiId);

        // Assert
        verify(tournoiRepository).delete(tournoiId); // Vérifiez que la méthode delete a été appelée
    }
}
