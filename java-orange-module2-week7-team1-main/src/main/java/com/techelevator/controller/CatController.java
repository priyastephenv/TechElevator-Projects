package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards") //needs this to access APIs
public class CatController {


    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    @GetMapping//Changed all of these in reference to their function and to call the one at the top
    public List<CatCard> allCats (){
        return catCardDao.getCatCards();//gets all catcards
    }

    @GetMapping("/{id}")
    public CatCard getCatCardByID (@PathVariable int id){
        return catCardDao.getCatCardById(id);// get a specific cat card by id

    }

    @RequestMapping("/random")
    public CatCard getRandomCat(){
        //initiate random cat
        CatCard randomCatCard = new CatCard();

        //get the random cat fact from the web api and save it to random cat
        CatFact randomCatFact = catFactService.getFact();
        String catFactAsString = randomCatFact.getText();
        randomCatCard.setCatFact(catFactAsString);

        //get the random cat picture and save it to random cat
        CatPic randomCatPic = catPicService.getPic();
        String randomCatURL = randomCatPic.getFile();
        randomCatCard.setImgUrl(randomCatURL);

        return randomCatCard;

    }
    @PostMapping
    public CatCard add(@RequestBody CatCard catCardToBeSaved) {
        return catCardDao.createCatCard(catCardToBeSaved);// adds new catcard to DB
    }
    @PutMapping ("/{id}")
    public CatCard update (@PathVariable int id, @Valid @RequestBody CatCard catCardToUpdate){
            catCardToUpdate.setCatCardId(id);//sets id of catcard to be updated
        try {
            CatCard updatedCatCard = catCardDao.updateCatCard(catCardToUpdate);//updates catcard in db
            return updatedCatCard;
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found");//exception if card cannot be located
        }
    }
    @DeleteMapping ("/{id}")
    public void deleteCatCard (@PathVariable int id){

        catCardDao.deleteCatCardById(id);// deletes catcard from db by ID
    }

}
