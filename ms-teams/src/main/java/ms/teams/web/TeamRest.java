package ms.teams.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.teams.dao.TeamRepository;
import ms.teams.model.Team;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class TeamRest {

    private final TeamRepository teamRepository;

    @Value("${ms.player.service.url}") // Poprawna składnia odwołania do properties
    private String playerServiceUrl;

    @GetMapping("/teams")
    public List<Team> getTeams() {
        log.info("about to retrieve teams list");
        List<Team> teams = teamRepository.findAll();
        teams.forEach(this::fillPlayerNames);
        return teams;
    }

    @GetMapping("/players/{id}/teams")
    public List<Team> getTeamsByPlayer(@PathVariable int id){
        log.info("about to retrieve teams by players {}", id);
        List<Team> teams = teamRepository.findTeamsByPlayersIsContaining(id);
        teams.forEach(this::fillPlayerNames);
        return teams;
    }

    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    private void fillPlayerNames(Team team){
        team.getPlayers().forEach(playerId -> {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<PlayerDto> responseEntity = restTemplate.exchange(
                    playerServiceUrl + "/players/" + playerId,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    PlayerDto.class
            );

            String playerName = responseEntity.getBody().getName();
            team.getPlayerNames().add(playerName);
        });
    }

    @Data
    static class PlayerDto {
        private int id;
        private String name;
        private String photoUrl;
        private float marketValue;
    }

}