package com.aakam.sample.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.aakam.sample.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class CharacterModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(CharacterView.Summary.class)
	private Long characterId;

	@JsonView(CharacterView.Detail.class)
	private String biography;

	@JsonView(CharacterView.Summary.class)
	private String name;

	@JsonView(CharacterView.Summary.class)
	private User player;

	public CharacterModel(Long characterId, String name, String biography, User player) {
		this.characterId = characterId;
		this.name = name;
		this.biography = biography;
		this.player = player;
	}

	public CharacterModel(Long characterId) {
		this.characterId = characterId;
	}

	public Long getCharacterId() {
		return this.characterId;
	}

	public void setUserId(Long userId) {
		this.characterId = userId;
	}

	public String getBiography() {
		return this.biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

}
