package com.glinzac.games;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository  extends CrudRepository<Game,Integer> {

    @Query(value = "select * from game where title like  :name% ;",nativeQuery = true)
    List<Game> gameList(@Param("name") String title_name);

    @Query(value = "select id from game where title = :gtitle  && platform = :gplatform",nativeQuery = true)
    int getDataId(@Param("gtitle") String title, @Param("gplatform") String platform);
}
