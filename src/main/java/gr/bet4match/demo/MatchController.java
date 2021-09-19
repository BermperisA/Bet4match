package gr.bet4match.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    MatchRepository matchRepository;
    @Autowired
    MatchOddsRepository matchOddsRepository;


    @GetMapping("/{id}")
    MatchEntity getMatch(@PathVariable int id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find match " + id));
    }

    @GetMapping("/{matchid}/odds/{id}")
    MatchOddsEntity getOdd(@PathVariable int matchid, @PathVariable int id) {
        return matchOddsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find match odds" + id));
    }

    @GetMapping("/")
    List<MatchEntity> getAllMatches() {
        return (List<MatchEntity>) matchRepository.findAll();
    }

    @GetMapping("/odds")
    List<MatchOddsEntity> getAllOdds() {
        return (List<MatchOddsEntity>) matchOddsRepository.findAll();
    }

    @PostMapping("/")
    MatchEntity newMatch(@RequestBody MatchEntity newMatch) {
        return matchRepository.save(newMatch);
    }

    @PostMapping("/{id}/odds")
    MatchOddsEntity newMatchOdds(@RequestBody MatchOddsEntity newMatchOdds, @PathVariable int id) {
        return matchRepository.findById(id)
                .map(match -> {
                    newMatchOdds.setMatchEntity(match);
                    return matchOddsRepository.save(newMatchOdds);
                })
                .orElseThrow(() -> new NotFoundException("Could not find match " + id));
    }

    @PutMapping("/{matchid}/odds/{id}")
    MatchOddsEntity updateMatchOdds(@RequestBody MatchOddsEntity newMatchOdds, @PathVariable int matchid, @PathVariable int id) {

        return matchOddsRepository.findById(id)
                .map(odds -> {
                    odds.setOdd(newMatchOdds.getOdd());
                    odds.setSpecifier(newMatchOdds.getSpecifier());
                    return matchOddsRepository.save(odds);
                })
                .orElseGet(() -> {
                    return newMatchOdds(newMatchOdds, id);
                });
    }

    @PutMapping("{id}")
    MatchEntity updateMatch(@RequestBody MatchEntity newMatch, @PathVariable int id) {

        return matchRepository.findById(id)
                .map(match -> {
                    match.setDescription(newMatch.getDescription());
                    match.setMatchDate(newMatch.getMatchDate());
                    match.setMatchTime(newMatch.getMatchTime());
                    match.setSport(newMatch.getSport());
                    match.setTeamA(newMatch.getTeamA());
                    match.setTeamB(newMatch.getTeamB());
                    return matchRepository.save(match);
                })
                .orElseGet(() -> {
                    return matchRepository.save(newMatch);
                });
    }

    @DeleteMapping("/{id}")
    void deleteMatch(@PathVariable int id) {
        matchRepository.deleteById(id);
    }
    @DeleteMapping("/odds/{id}")
    void deleteOdds(@PathVariable int id) {
        matchOddsRepository.deleteById(id);
    }
}
