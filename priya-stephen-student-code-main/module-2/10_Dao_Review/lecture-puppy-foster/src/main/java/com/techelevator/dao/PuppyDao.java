package com.techelevator.dao;

import com.techelevator.model.Puppy;

import java.util.List;

public interface PuppyDao {

    /*
     * What methods are needed by the puppy foster app??
     */

    List<Puppy> getAllPuppies();

    Puppy getPuppyById(int puppyId);

    Puppy addPuppy(Puppy puppyToAdd);
}
