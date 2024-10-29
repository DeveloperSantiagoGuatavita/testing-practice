package org.mock.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

//@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {

    @Mock
    private PlayerRepositoryImpl playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        //Given (En este caso el given se hizo a nivel de clase con el tema de mocks y sus anotaciones)

        //When
        when(playerRepository.findall()).thenReturn(DataProvider.getPlayersMock());
        List<Player> playerList = playerService.findall();

        //Then
        assertNotNull(playerList);
        assertFalse(playerList.isEmpty());
        assertEquals("Pedro", playerList.getFirst().getName());
        verify(playerRepository).findall();
    }

    @Test
    void testFindById() {
        //Given
        Long id = 1L;


        //When
        when(playerRepository.findById(id)).thenReturn(DataProvider.getPlayerByIdMock());
        Player player = playerService.findById(id);

        //Then
        assertNotNull(player);
        assertEquals("Pedro", player.getName());
        verify(playerRepository).findById(anyLong());
    }

    @Test
    void testSavePlayer() {
        //Given
        Player newPlayer = DataProvider.newPlayerMock();

        //When
        playerService.savePlayer(newPlayer);

        //Then
        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(playerRepository).savePlayer(any());
        verify(playerRepository).savePlayer(playerArgumentCaptor.capture());
        assertEquals(4L, playerArgumentCaptor.getValue().getId());
        assertEquals("Julian", playerArgumentCaptor.getValue().getName());
    }

    @Test
    void testDeleteById() {
        //Given
        Long id = 1L;

        //When
        playerService.deleteById(id);

        //Then
        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(playerRepository).deleteById(anyLong());
        verify(playerRepository).deleteById(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue());
    }
}
