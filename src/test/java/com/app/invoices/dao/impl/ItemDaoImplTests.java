package com.app.invoices.dao.impl;

import com.app.invoices.TestDataUtil;
import com.app.invoices.domain.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ItemDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ItemDaoImpl underTest;

    @Test
    public void testThatCreateItemGeneratesCorrectSql(){
        Item item = TestDataUtil.createTestItemA();

        underTest.create(item);

        verify(jdbcTemplate).update(
                eq("INSERT INTO items (id, invoice_id, name, price, quantity) VALUES (?, ?, ?, ?, ?)"),
                eq(1L), eq(1L), eq("Nome do item"), eq(1500f), eq(1f)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql(){
        underTest.findOne(1L);

        verify(jdbcTemplate).query(
                eq("SELECT * FROM items WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<ItemDaoImpl.ItemRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        underTest.find();

        verify(jdbcTemplate).query(
                eq("SELECT * FROM items"),
                ArgumentMatchers.<ItemDaoImpl.ItemRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSql(){
        Item item = TestDataUtil.createTestItemA();
        underTest.update(item.getId(), item);

        verify(jdbcTemplate).update(
                eq("UPDATE items SET id = ?, invoice_id = ?, name = ?, price = ?, quantity = ? WHERE id = ?"),
                eq(1L), eq(1L), eq("Nome do item"), eq(1500f), eq(1f), eq(1L)
        );
    }

    @Test
    public void testThatDeleteItemGeneratesCorrectSql() {
        underTest.delete(1L);

        verify(jdbcTemplate).update(
                "DELETE FROM items WHERE id = ?",
                1L
        );
    }
}
