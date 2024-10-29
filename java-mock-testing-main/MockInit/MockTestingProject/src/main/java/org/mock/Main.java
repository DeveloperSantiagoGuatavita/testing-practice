package org.mock;


import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;
import org.mock.service.PlayerServiceImpl;

public class Main {
    public static void main(String[] args) {
        PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();
        PlayerServiceImpl playerService = new PlayerServiceImpl(playerRepository);


    }
}