package com.app.invoices.dao.impl;

import com.app.invoices.dao.ItemDao;
import com.app.invoices.domain.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class ItemDaoImpl implements ItemDao {

    private final JdbcTemplate jdbcTemplate;

    public ItemDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Item item) {
        jdbcTemplate.update(
                "INSERT INTO items (id, invoice_id, name, price, quantity) VALUES (?, ?, ?, ?, ?)",
                item.getId(), item.getInvoiceId(), item.getName(), item.getPrice(), item.getQuantity()
        );
    }

    @Override
    public Optional<Item> findOne(long itemId) {
        List<Item> result = jdbcTemplate.query(
                "SELECT * FROM items WHERE id = ? LIMIT 1",
                new ItemRowMapper(), itemId
        );

        return result.stream().findFirst();
    }

    public static class ItemRowMapper implements RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Item.builder()
                    .id(rs.getLong("id"))
                    .invoiceId(rs.getLong("invoice_id"))
                    .name(rs.getString("name"))
                    .price(rs.getFloat("price"))
                    .quantity(rs.getFloat("quantity"))
                    .build();
        }
    }

    @Override
    public List<Item> find() {
        return jdbcTemplate.query(
                "SELECT * FROM items",
                new ItemRowMapper()
        );
    }

    @Override
    public void update(long id, Item item) {
        jdbcTemplate.update(
                "UPDATE items SET id = ?, invoice_id = ?, name = ?, price = ?, quantity = ? WHERE id = ?",
                item.getId(), item.getInvoiceId(), item.getName(), item.getPrice(), item.getQuantity(), id
        );
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update(
                "DELETE FROM items WHERE id = ?",
                id
        );
    }


}
