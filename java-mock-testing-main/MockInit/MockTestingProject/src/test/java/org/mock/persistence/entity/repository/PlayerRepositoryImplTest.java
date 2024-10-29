package org.mock.persistence.entity.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerRepositoryImplTest {


    private static PlayerRepositoryImpl playerRepository;

    @BeforeEach
    void init() {
        playerRepository = new PlayerRepositoryImpl();
    }

    @Test
    void findall() {
        //Given

        //When
        List<Player> playerList = playerRepository.findall();

        //Then
        assertNotNull(playerList);
        assertEquals("Santi", playerList.getFirst().getName());

    }

    @Test
    void findById() {
        //Given
        Long id = 1L;

        //When
        Player player = playerRepository.findById(id);

        //Then
        assertNotNull(player);
        assertEquals("America de cali", player.getTeam());
    }

    @Test
    void findByIdError() {
        //Given
        Long id = 5L;

        //When Then
        assertThrows(Exception.class, () -> {
            playerRepository.findById(id);
        });
    }

    @Test
    void savePlayer() {
        //Given
        Player player = DataProvider.newPlayerMock();

        //When
        playerRepository.savePlayer(player);

        //Then
        Player playerAdded = playerRepository.findById(player.getId());
        assertNotNull(playerAdded);
        assertEquals(4L, playerAdded.getId());


    }

    @Test
    void deleteById() {
        //Given
        Long id = 1L;

        //When
        playerRepository.deleteById(id);

        //Then
        assertThrows(NoSuchElementException.class, () -> {
            playerRepository.findById(id);
        });

    }
}