package me.sangca.itemdbserver.repository;

import me.sangca.itemdbserver.entity.SerializedItemStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SerializedItemStackRepository extends JpaRepository<SerializedItemStack, Integer> {

//    @Query("DELETE "
//        + "FROM SerializedItemStack s "
//        + "WHERE "
//        + "   s.category LIKE :category "
//        + "   AND s.key LIKE :key")
//    public void deleteByCategoryAndKey(@Param("category") String category, @Param("key") String key);

    @Transactional
    public void deleteByCategoryAndKey(String category, String key);

    @Query("SELECT DISTINCT s "
        + "FROM serialized_item_stack s "
        + "WHERE "
        + "   s.category LIKE :category "
        + "   AND s.key LIKE :key")
    public SerializedItemStack findByCategoryAndKey (@Param("category") String category, @Param("key") String key);

    //public void deleteByEmbeddableIdCategoryAndEmbeddableIdKey(String category, String key);

    //public SortedItemStack findByEmbeddableIdCategoryAndEmbeddableIdKey (String category, String key);
}
