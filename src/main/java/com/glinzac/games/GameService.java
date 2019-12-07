package com.glinzac.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public long getTotalCount() {
        return  gameRepository.count();
    }

    public List<Game> getGameList(String name) {
        return gameRepository.gameList(name);
    }

    public String createNewData(GameData gameObj) {
        try {
            Game newGame = new Game();
            newGame.setTitle(gameObj.getTitle());
            newGame.setEditors_choice(gameObj.getEditors_choice());
            newGame.setGenre(gameObj.getGenre());
            newGame.setPlatform(gameObj.getPlatform());
            newGame.setScore(gameObj.getScore());
            gameRepository.save(newGame);
            return "200 OK Data Created";
        }
        catch (Exception e){
            return "400 Error in data";
        }
    }

    public String updateData(List<GameData> gameData) {
        Integer gameId=0;
        try{
            gameId = gameRepository.getDataId(gameData.get(0).getTitle(),gameData.get(0).getPlatform());
        }catch (Exception e){
            return "404 Data Not Found";
        }
        try{
            Game updateData = gameRepository.findById(gameId).get();
            updateData.setScore(gameData.get(1).getScore());
            updateData.setPlatform(gameData.get(1).getPlatform());
            updateData.setGenre(gameData.get(1).getGenre());
            updateData.setEditors_choice(gameData.get(1).getEditors_choice());
            updateData.setTitle(gameData.get(1).getTitle());
            gameRepository.save(updateData);
        }catch (Exception e){
            return "400 Error in data";
        }
        return "200 OK Updated Successfully";
    }

    public String deleteData(GameData gameData) {
        Integer gameId=0;
        try{
            gameId = gameRepository.getDataId(gameData.getTitle(),gameData.getPlatform());
        }catch (Exception e){
            return "404 Data Not Found";
        }
        try{
            gameRepository.deleteById(gameId);
        }catch (Exception e){
            return "404 Data Not Found";
        }
        return "200 OK Deleted Successfully";
    }
}
