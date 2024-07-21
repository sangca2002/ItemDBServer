package me.sangca.itemdbserver.service;

import me.sangca.itemdbserver.entity.SortedItemStack;
import me.sangca.itemdbserver.repository.SortedItemStackRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemStackService {

    public final SortedItemStackRepository sortedItemStackRepository;

    public ItemStackService(SortedItemStackRepository sortedItemStackRepository) {
        this.sortedItemStackRepository = sortedItemStackRepository;
    }

    public List<SortedItemStack> getItemList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page-1, 10, Sort.by(sorts));
//        List<SortedItemStack> itemStackList = this.sortedItemStackRepository.findAll(pageable).getContent();
//        HashMap<ArrayList<String>,String> itemMap = new HashMap<>();
//
//        int i = 0;
//        while (i < itemStackList.size()) {
//            ArrayList<String> categoryAndKeyAsList = new ArrayList<>();
//            categoryAndKeyAsList.add(itemStackList.get(i).getCategory());
//            categoryAndKeyAsList.add(itemStackList.get(i).getKey());
//            itemMap.put(categoryAndKeyAsList,itemStackList.get(i).getItemStackAsString());
//            i += 1;
//        }
//        return itemMap;
        return this.sortedItemStackRepository.findAll(pageable).getContent();
    }

    public void saveItem(String category, String key, String itemStackAsString) {
        sortedItemStackRepository.save(new SortedItemStack(category, key, itemStackAsString));
    }

    public void deleteItem(String category, String key) {
        sortedItemStackRepository.deleteByCategoryAndKey(category, key);
    }

    public String getItem(String category, String key) {
        return sortedItemStackRepository
            .findByCategoryAndKey(category, key)
            .getItemStackAsString();
    }
}
