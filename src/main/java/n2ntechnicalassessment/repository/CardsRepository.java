package n2ntechnicalassessment.repository;

import n2ntechnicalassessment.dto.CardsDto;
import n2ntechnicalassessment.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

    @Query(value = "SELECT * FROM cards c ORDER BY RAND( ) LIMIT 4;", nativeQuery = true)
    List<Cards> getPlayerCardsBasedOnNumber();

}
