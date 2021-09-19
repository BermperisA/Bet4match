package gr.bet4match.demo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "Matches", schema = "techtpia_bet4match", catalog = "")
public class MatchEntity {
    private int id;
    private String description;
    private Date matchDate;
    private Time matchTime;
    private String teamA;
    private String teamB;
    private int sport;

    public MatchEntity() {
    }

    public MatchEntity(String description, Date matchDate, Time matchTime, String teamA, String teamB, int sport) {
        this.description = description;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "match_date")
    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    @Basic
    @Column(name = "match_time")
    public Time getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Time matchTime) {
        this.matchTime = matchTime;
    }

    @Basic
    @Column(name = "team_a")
    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    @Basic
    @Column(name = "team_b")
    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    @Basic
    @Column(name = "sport")
    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchEntity that = (MatchEntity) o;
        return id == that.id &&
                sport == that.sport &&
                Objects.equals(description, that.description) &&
                Objects.equals(matchDate, that.matchDate) &&
                Objects.equals(matchTime, that.matchTime) &&
                Objects.equals(teamA, that.teamA) &&
                Objects.equals(teamB, that.teamB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, matchDate, matchTime, teamA, teamB, sport);
    }
}
