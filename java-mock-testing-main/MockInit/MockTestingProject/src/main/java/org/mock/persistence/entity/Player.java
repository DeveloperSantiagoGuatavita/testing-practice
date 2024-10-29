package org.mock.persistence.entity;

import java.util.Objects;

public class Player {
    private Long id;
    private String name;
    private String team;
    private String position;

    public Player(Long id, String name, String team, String position) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(team, player.team) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, team, position);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public Player() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
