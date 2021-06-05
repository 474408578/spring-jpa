package com.xschen.spring.jpa.overview.ch01_6.controller;

import com.xschen.spring.jpa.overview.ch01_6.domain.RedBook;
import com.xschen.spring.jpa.overview.ch01_6.repository.RedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * @author xschen
 */

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private RedBookRepository redBookRepository;

    @GetMapping("redBook")
    public RedBook getRedBook(@RequestParam("id") Long id) {
        Optional<RedBook> redBook = redBookRepository.findById(id);
        return redBook.get();
    }

    @PostConstruct
    public void initData() {
        RedBook redBook = new RedBook();
        redBook.setTitle("redBook");
        redBook.setRedMark("redMark");
        redBook.setId(1L);
        redBookRepository.saveAndFlush(redBook);

    }
}
