package org.mock.persistence.entity.repository;

import org.mock.persistence.entity.Player;

import java.util.List;

public interface IPlayerRepository {
    List<Player> findall();
    Player findById(Long id);
    void savePlayer(Player player);
    void deleteById(Long id);
}
