package me.sangca.itemdbserver.controller;

import me.sangca.itemdbserver.entity.SortedItemStack;
import me.sangca.itemdbserver.service.ItemStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemStackController {

    private final ItemStackService itemStackService;

    @Autowired
    public ItemStackController(ItemStackService itemStackService) {
        this.itemStackService = itemStackService;
    }

    @GetMapping("/itemlist/{page}")
    @ResponseBody
    public List<SortedItemStack> itemListRequest(@PathVariable("page") String page) {
        return itemStackService.getItemList(Integer.parseInt(page));
    }

    @PostMapping("/items/{category}/{key}")
    @ResponseBody
    public void itemPostRequest(
        @PathVariable("category") String category,
        @PathVariable("key") String key,
        @RequestBody String itemStackAsString) {
        itemStackService.saveItem(category, key, itemStackAsString);
    }

    @DeleteMapping("/items/{category}/{key}")
    @ResponseBody
    public void itemDeleteRequest(@PathVariable("category") String category, @PathVariable("key") String key) {
        itemStackService.deleteItem(category, key);
    }

    @GetMapping("/items/{category}/{key}")
    @ResponseBody
    public String itemGetRequest(@PathVariable("category") String category, @PathVariable("key") String key) {
        return itemStackService.getItem(category, key);
    }
}
