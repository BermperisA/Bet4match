package gr.bet4match.demo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MatchOdds", schema = "techtpia_bet4match", catalog = "")
public class MatchOddsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private MatchEntity matchEntity;

    @Basic
    @Column(name = "specifier")
    private String specifier;

    @Basic
    @Column(name = "odd")
    private double odd;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSpecifier() {
        return specifier;
    }
    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public MatchEntity getMatchEntity() {
        return matchEntity;
    }
    public void setMatchEntity(MatchEntity matchEntity) {
        this.matchEntity = matchEntity;
    }

    public double getOdd() {
        return odd;
    }
    public void setOdd(double odd) {
        this.odd = odd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchOddsEntity that = (MatchOddsEntity) o;
        return id == that.id &&
                odd == that.odd &&
                Objects.equals(specifier, that.specifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specifier, odd);
    }
}
