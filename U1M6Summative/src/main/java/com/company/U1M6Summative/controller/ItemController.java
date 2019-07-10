package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

  /*  private List<Item> list = new ArrayList<>();

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Item addItem(@RequestBody @Valid Item item) {
        list.add(item);
        return item;
    }

    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void putItem(@RequestBody @Valid Item item) {
        int pos = 0;
        boolean found = false;

        for(Item newItem : list) {
            if (item.getItemId() == item.getItemId()) {
                found = true;
                item.setDailyRate(newItem.getDailyRate());
                item.setDescription(newItem.getDescription());
                item.setName(newItem.getName());
                break;
            }

            pos++;
        }

        if ( !found ) throw new IllegalArgumentException("item not found.");
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCity(@PathVariable int id) {

        int pos = 0;
        boolean found = false;

        for(Item item : list) {
            if (item.getItemId() == id) {
                found = true;
                break;
            }

            pos++;
        }

        if ( found )
            list.remove(pos);
        else throw new IllegalArgumentException("item not found.");
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Item> getItems() {

        return list;
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Item getItem(@PathVariable int id) {

        for(Item item : list) {
            if (item.getItemId()== id)
                return item;
        }

        throw new IllegalArgumentException("item not found.");
    }*/

}
