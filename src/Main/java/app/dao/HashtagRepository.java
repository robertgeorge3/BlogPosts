package app.dao;

import app.dto.Hashtags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtags, Integer> {

    Boolean existsHashtagByPhrase(String phrase);

    //Hashtags getHashtagByPhrase(String phrase);
}
