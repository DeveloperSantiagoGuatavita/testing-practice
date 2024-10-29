package org.mock;

import org.mock.persistence.entity.Player;

import java.util.List;

public class DataProvider {

    public static List<Player> getPlayersMock() {
        System.out.println("Obteniendo players simulados");
        return List.of(
                new Player(1L, "Pedro", "America de cali", "volante"),
                new Player(2L, "Jhon", "Nacional", "volante"),
                new Player(3L, "Sebas", "Millonarios", "volante")
        );
    }

    public static Player getPlayerByIdMock() {
        return new Player(1L, "Pedro", "America de cali", "volante");
    }

    public static Player newPlayerMock() {
        return new Player(4L, "Julian", "America de cali", "volante");
    }
}
