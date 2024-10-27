package org.toure.TestService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.toure.Model.Equipe;
import org.toure.Repository.interfaces.EquipeRepository;
import org.toure.Service.EquipeService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EquipeServiceTest {

    @Mock
    private EquipeRepository equipeRepository;

    @InjectMocks
    private EquipeService equipeService;

    private Equipe equipe;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        equipe = new Equipe();
        equipe.setId(1L);
        equipe.setNom("Equipe Test");
    }

    @Test
    public void testAjouterEquipe() {
        when(equipeRepository.create(equipe)).thenReturn(equipe);

        Equipe result = equipeService.ajouterEquipe(equipe);

        assertNotNull(result);
        assertEquals(equipe.getNom(), result.getNom());
        verify(equipeRepository, times(1)).create(equipe);
    }

    @Test
    public void testModifierEquipe() {
        when(equipeRepository.update(equipe, 1L)).thenReturn(equipe);

        Equipe result = equipeService.ModifierEquipe(equipe, 1L);

        assertNotNull(result);
        assertEquals(equipe.getNom(), result.getNom());
        verify(equipeRepository, times(1)).update(equipe, 1L);
    }

    @Test
    public void testSupprimeEquipe() {
        equipeService.SuppremeEquipe(1L);

        verify(equipeRepository, times(1)).delete(1L);
    }

    @Test
    public void testGetAllEquipe() {
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(equipe);
        when(equipeRepository.getAll()).thenReturn(equipes);

        List<Equipe> result = equipeService.getAllEquipe();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(equipe, result.get(0));
        verify(equipeRepository, times(1)).getAll();
    }

    @Test
    public void testGetByName() {
        when(equipeRepository.getByName("Equipe Test")).thenReturn(equipe);

        Equipe result = equipeService.getbyname("Equipe Test");

        assertNotNull(result);
        assertEquals(equipe.getNom(), result.getNom());
        verify(equipeRepository, times(1)).getByName("Equipe Test");
    }
}
