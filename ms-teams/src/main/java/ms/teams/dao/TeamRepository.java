package ms.teams.dao;

import ms.teams.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findTeamsByPlayersIsContaining(int id);
}
