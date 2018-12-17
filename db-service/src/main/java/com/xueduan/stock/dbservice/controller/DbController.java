package com.xueduan.stock.dbservice.controller;
import com.xueduan.stock.dbservice.model.Quote;
import com.xueduan.stock.dbservice.model.Quotes;
import com.xueduan.stock.dbservice.repository.QuotesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbController {
    private QuotesRepository quotesRepository;
    public DbController(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }


    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username) {
        quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
        return getQuotesByUserName(username);
    }

    private List<String> getQuotesByUserName(String username) {
        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes) {
        quotes.getQuotes()
                .stream()
                .map(quote->new Quote(quotes.getUserName(), quote))
                .forEach(quote->quotesRepository.save(quote));
        return getQuotesByUserName(quotes.getUserName());
    }

    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {
        List<Quote> quotes = quotesRepository.findByUserName(username);
        quotesRepository.delete(quotes);
        return getQuotesByUserName(username);
    }
}
