package org.mock.persistence.entity.repository;

import org.mock.persistence.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements IPlayerRepository{

    private List<Player> playerDatabase = new ArrayList<>(List.of(
            new Player(1L, "Santi", "America de cali", "volante"),
            new Player(2L, "Jhon", "Nacional", "volante"),
            new Player(3L, "Sebas", "Millonarios", "volante")
    ));

    @Override
    public List<Player> findall() {
        System.out.println("-> Metodo findAll real!!!");
        return this.playerDatabase;
    }

    @Override
    public Player findById(Long id) {
        System.out.println("-> Metodo findbyid real!!!");
        return playerDatabase.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void savePlayer(Player player) {
        System.out.println("-> Metodo savePlayer real!!!");
        this.playerDatabase.add(player);
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("-> Metodo deleteById real!!!");
        this.playerDatabase = this.playerDatabase.stream()
                .filter(p -> p.getId() != id)
                .toList();
    }
}
