package com.trung.qotd.dao;

import com.trung.qotd.entity.Quote;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuoteDAO {
	private static List<Quote> quotes;
	
	private int getNumRecord() {
		return quotes.size();
	}
	
	public QuoteDAO() {
		if (quotes == null)
			quotes = new ArrayList<>();
	}

	public void saveOne(Quote quote) {
		quotes.add(quote);
	}
	
	public Quote getLatestOne(Quote quote) {
		int lastIndex = quotes.size() - 1;

		if (lastIndex < 0)
			return null;

		return quotes.get(lastIndex);
	}
	
	public List<Quote> getMany(int startIndex, int numRecord) {
		int numQuote = this.getNumRecord();

		List<Quote> result = new ArrayList<>();
		
		if (startIndex < 0 || numRecord < 0 || startIndex >= numRecord) {
			return result;
		}
		
		if (startIndex + numRecord > numQuote) {
			numRecord = numQuote - startIndex;
		}
		
		for(int index = startIndex; index < startIndex + numRecord; ++index) {
				result.add(quotes.get(index));
		}
		
		return result;
	}
	
	public List<Quote> getMany(int numRecord) {
		return this.getMany(0, numRecord);
	}
}
