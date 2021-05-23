package app.server.repository;

import app.server.domain.Language;
import app.server.domain.Word;
import app.server.utils.TranslateData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Language, Integer> {

    @Query("""
    SELECT new app.server.utils.TranslateData(w1.value, wc1.partOfSpeech, w2.value) FROM word_concept wc1
                	LEFT JOIN Word w1 ON wc1.word = w1
                	LEFT JOIN word_concept wc2 ON wc1.concept = wc2.concept
                	LEFT JOIN Word w2 ON wc2.word = w2
                	WHERE w1.language = :from AND w2.language = :to
                	ORDER BY w1.value ASC
""")
    List<TranslateData> getTranslateData(@Param("from") Language from, @Param("to") Language to);

    @Modifying
    @Query("""
        UPDATE Language l SET l.name = :name, l.alphabet = :alphabet WHERE l.id = :id
        """)
    void updateLanguage(@Param("id") Integer id, @Param("name") String name, @Param("alphabet") String alphabet);

    @Modifying
    @Query("DELETE FROM Language l WHERE l.name = :name")
    void deleteByName(@Param("name") String name);
}
