package ms.players.dao;

import ms.players.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findPlayersByCoachId(int id);

}
