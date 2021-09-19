package gr.bet4match.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("matchOddsRepository")
public interface MatchOddsRepository extends CrudRepository<MatchOddsEntity, Integer> {
}
