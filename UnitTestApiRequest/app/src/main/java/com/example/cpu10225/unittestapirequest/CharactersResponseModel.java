package com.example.cpu10225.unittestapirequest;

import com.example.cpu10225.unittestapirequest.model.CharacterModel;

import java.util.List;

/**
 * Created by cpu10225 on 22/12/2017.
 */

public class CharactersResponseModel {

    public final int count;
    public final String next;
    public final String previous;
    public final List<CharacterModel> results;

    public CharactersResponseModel(int count, String next, String previous, List<CharacterModel> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }
}