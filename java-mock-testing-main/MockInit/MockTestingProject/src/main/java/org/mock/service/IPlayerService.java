package org.mock.service;

import org.mock.persistence.entity.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findall();
    Player findById(Long id);
    void savePlayer(Player player);
    void deleteById(Long id);
}
