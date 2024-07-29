package com.app.invoices.dao;

import com.app.invoices.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemDao {

    void create(Item item);

    Optional<Item> findOne(long id);

    List<Item> find();

    void update(long id, Item item);

    void delete(long id);
}
