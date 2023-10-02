package me.may.suit.dto;

import java.util.List;

import me.may.attribute.dto.Attribute;

/**
 * Suit - 数据模型
 * 
 * @author May_Speed
 */
public class Suit {

	private String name;
	private List<Attribute> addtionData;

	public Suit(String name, List<Attribute> addtionData) {
		this.name = name;
		this.addtionData = addtionData;
	}

	@Override
	public String toString() {
		return "Suit [name=" + name + ", addtionData=" + addtionData + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Attribute> getAddtionData() {
		return addtionData;
	}

	public void setAddtionData(List<Attribute> addtionData) {
		this.addtionData = addtionData;
	}
}
