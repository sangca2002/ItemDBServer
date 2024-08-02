package me.sangca.itemdbserver.service;

import me.sangca.itemdbserver.entity.SerializedItemStack;
import me.sangca.itemdbserver.repository.SerializedItemStackRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemStackService {

    public final SerializedItemStackRepository serializedItemStackRepository;

    public ItemStackService(SerializedItemStackRepository serializedItemStackRepository) {
        this.serializedItemStackRepository = serializedItemStackRepository;
    }

    public List<SerializedItemStack> getItemList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page-1, 10, Sort.by(sorts));
        return this.serializedItemStackRepository.findAll(pageable).getContent();
    }

    public void saveItem(String category, String key, String itemStackAsString) {
        serializedItemStackRepository.save(new SerializedItemStack(category, key, itemStackAsString));
    }

    public void deleteItem(String category, String key) {
        serializedItemStackRepository.deleteByCategoryAndKey(category, key);
    }

    public String getItem(String category, String key) {
        return serializedItemStackRepository
            .findByCategoryAndKey(category, key)
            .getItemStackAsString();
    }
}
