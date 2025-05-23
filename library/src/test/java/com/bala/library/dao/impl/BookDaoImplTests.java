package com.bala.library.dao.impl;


import com.bala.library.domain.Book;
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
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql(){
        Book book = Book.builder()
                        .isbn("968-1-1032-1232-0")
                        .title("The Shadow in the Attic")
                        .authorId(1L)
                        .build();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("968-1-1032-1232-0"),
                eq("The Shadow in the Attic"),
                eq(1L)
        );
    }

    @Test
    public void testThatFineOneBookGeneratesCorrectSql(){
        underTest.find("968-1-1032-1232-0");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, authorId FROM BOOKS authors where isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("968-1-1032-1232-0")
        );
    }
}
