package me.may.suit.dao;

import java.util.ArrayList;
import java.util.List;

import me.may.suit.dto.Suit;

public class SuitDao {

	private static List<Suit> suits = new ArrayList<Suit>();
	public static List<String> suitNames = new ArrayList<String>();
	
	public static List<Suit> getList() {
		return suits;
	}
	
	public static Suit getSuit(String suitName) {
		if (suitNames.isEmpty()) {
			return null;
		}
		for (Suit suit : suits) {
			if (suitName.indexOf(suit.getName()) != -1) {
				return suit;
			}
		}
		return null;
	}
}
