package org.toure.TestService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.toure.DAO.Implementation.TournoiDaoImpl;
import org.toure.Model.Statut;
import org.toure.Model.Tournoi;
import org.toure.Repository.interfaces.TournoiRepository;
import org.toure.Service.TournoiService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TournoiServiceTest {

    @Mock
    private TournoiRepository tournoiRepository;

    @Mock
    private TournoiDaoImpl tournoiDao;

    @InjectMocks
    private TournoiService tournoiService;

    private Tournoi tournoi;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tournoi = new Tournoi();
        tournoi.setId(1L);
        tournoi.setStatut(Statut.EN_COURS);
    }

    @Test
    public void testGetTournoi() {
        when(tournoiRepository.findById(1L)).thenReturn(tournoi);

        Tournoi result = tournoiService.getTournoi(1L);

        assertNotNull(result);
        assertEquals(tournoi.getId(), result.getId());
        verify(tournoiRepository, times(1)).findById(1L);
    }

    @Test
    public void testAjouterTournoi() {
        tournoiService.ajouterTournoi(tournoi);

        verify(tournoiRepository, times(1)).create(tournoi);
        assertEquals(Statut.EN_COURS, tournoi.getStatut());
    }

    @Test
    public void testModifierTournoi() {
        tournoiService.ModifierTournoi(tournoi, 1L);

        verify(tournoiRepository, times(1)).update(tournoi, 1L);
    }

    @Test
    public void testSupprimeTournoi() {
        tournoiService.SuppremeTouroi(1L);

        verify(tournoiRepository, times(1)).delete(1L);
    }

    @Test
    public void testGetAllTournois() {
        List<Tournoi> tournois = new ArrayList<>();
        tournois.add(tournoi);
        when(tournoiRepository.getAllTournois()).thenReturn(tournois);

        List<Tournoi> result = tournoiService.getAllTournois();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(tournoi, result.get(0));
        verify(tournoiRepository, times(1)).getAllTournois();
    }
}
