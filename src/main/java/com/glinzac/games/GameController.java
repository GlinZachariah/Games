package com.glinzac.games;

import ch.qos.logback.core.CoreConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

//    Get the totalCount of the data
    @GetMapping("totalCount")
    public long getTotalGameCount(){
        return gameService.getTotalCount();
    }

//    Search based on Name (based on values that starts with )
    @GetMapping("searchName/{name}")
    public List<Game> getGames(@PathVariable String name){
        return gameService.getGameList(name);
    }

// Create Data
    @PostMapping("createData/")
    public String createData(@RequestBody GameData gameObj){
        return  gameService.createNewData(gameObj);
    }

//    Update Data
    @PutMapping("updateData/")
    public String updateData(@RequestBody List<GameData> gameData){
        return gameService.updateData(gameData);
    }

//    Delete Data
    @DeleteMapping("deleteData/")
    public String deleteData(@RequestBody GameData gameData){
        return gameService.deleteData(gameData);
    }

}
