package gr.bet4match.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import gr.bet4match.demo.MatchEntity;
import gr.bet4match.demo.MatchOddsEntity;

@Repository("matchRepository")
public interface MatchRepository extends CrudRepository<MatchEntity, Integer> {
}
