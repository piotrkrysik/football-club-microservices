package ms.players.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.players.dao.PlayerRepository;
import ms.players.model.Player;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/webapi")
@RequiredArgsConstructor
public class PlayerRest {

    private final PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> getPlayers() {
        log.info("about to get players");
        return playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        log.info("about to retrieve player {}", id);
        return playerRepository.findById(id).orElse(null);
    }

    @GetMapping("/coaches/{id}/players")
    public List<Player> getPlayersByCoach(@PathVariable int id) {
        log.info("about to retrieve players by coach {}", id);
        return playerRepository.findPlayersByCoachId(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        log.info("about to add new player");
        playerRepository.save(player);
        return player;
    }
}