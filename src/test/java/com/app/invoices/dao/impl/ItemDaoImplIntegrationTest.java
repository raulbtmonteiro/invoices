package com.app.invoices.dao.impl;

import com.app.invoices.TestDataUtil;
import com.app.invoices.domain.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ItemDaoImplIntegrationTest {

    private ItemDaoImpl underTest;

    @Autowired
    public ItemDaoImplIntegrationTest(ItemDaoImpl underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatItemCanBeCreatedAndRecalled(){
        Item item = TestDataUtil.createTestItemA();
        underTest.create(item);
        Optional<Item> result = underTest.findOne(item.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(item);
    }

    @Test
    public void testThatMultipleItemsCanBeCreatedAndRecalled(){
        Item itemA = TestDataUtil.createTestItemA();
        underTest.create(itemA);
        Item itemB = TestDataUtil.createTestItemB();
        underTest.create(itemB);
        Item itemC = TestDataUtil.createTestItemC();
        underTest.create(itemC);

        List<Item> result = underTest.find();
        assertThat(result)
                .hasSize(3)
                .containsOnly(itemA, itemB, itemC);

    }

    @Test
    public void testThatItemCanBeUpdated(){
        Item itemA = TestDataUtil.createTestItemA();
        underTest.create(itemA);
        itemA.setName("Updated name");
        underTest.update(itemA.getId(), itemA);
        Optional<Item> result = underTest.findOne(itemA.getId());
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Updated name");
        assertThat(result.get()).isEqualTo(itemA);
    }

    @Test
    public void testThatItemCanBeCreatedAndDeleted(){
        Item itemA = TestDataUtil.createTestItemA();
        underTest.create(itemA);
        Item itemB = TestDataUtil.createTestItemB();
        underTest.create(itemB);

        underTest.delete(itemA.getId());

        List<Item> result = underTest.find();
        assertThat(result)
                .hasSize(1)
                .containsOnly(itemB);

    }
}
