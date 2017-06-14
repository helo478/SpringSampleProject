package com.aakam.sample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aakam.sample.assembler.CharacterResourceAssembler;
import com.aakam.sample.dto.CharacterModel;
import com.aakam.sample.dto.User;
import com.aakam.sample.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	private CharacterResourceAssembler characterResourceAssembler;

	@RequestMapping(value = "/full", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public CharacterModel getFullCharacter() {
		CharacterModel model = new CharacterModel(1L, "TEST NAME", "TEST BIOGRAPHY", new User(1L, "Fred", "Flintstone"));
		return model;
	}

	@JsonView(CharacterView.Summary.class)
	@RequestMapping(value = "/resource-filtered", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Resource<CharacterModel> getFilteredCharacterWithResource() {
		CharacterModel model = new CharacterModel(1L, "TEST NAME", "TEST BIOGRAPHY", new User(1L, "Fred", "Flintstone"));
		return characterResourceAssembler.toResource(model);
	}

	@JsonView(CharacterView.Summary.class)
	@RequestMapping(value = "/filtered", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public CharacterModel getFilteredCharacter() {
		CharacterModel model = new CharacterModel(1L, "TEST NAME", "TEST BIOGRAPHY", new User(1L, "Fred", "Flintstone"));
		return model;
	}

	@JsonView(CharacterView.Summary.class)
	@RequestMapping(value = "/resource-resource-filtered", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Resource<Resource<CharacterModel>> getFilteredCharacterWithResourceResource() {
		CharacterModel model = new CharacterModel(1L, "TEST NAME", "TEST BIOGRAPHY", new User(1L, "Fred", "Flintstone"));
		return new Resource<Resource<CharacterModel>>(characterResourceAssembler.toResource(model));
	}

	@RequestMapping(value = "/resource-resource", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Resource<Resource<CharacterModel>> getFullCharacterWithResourceResource() {
		CharacterModel model = new CharacterModel(1L, "TEST NAME", "TEST BIOGRAPHY", new User(1L, "Fred", "Flintstone"));
		return new Resource<Resource<CharacterModel>>(characterResourceAssembler.toResource(model));
	}
}
