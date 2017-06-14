package com.aakam.sample.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.aakam.sample.dto.CharacterModel;
import com.aakam.sample.rest.CharacterController;

@Component
public class CharacterResourceAssembler implements ResourceAssembler<CharacterModel, Resource<CharacterModel>>{

	@Override
	public Resource<CharacterModel> toResource(CharacterModel user) {
		Resource<CharacterModel> resource = new Resource<CharacterModel>(user);
		resource.add(linkTo(CharacterController.class).withSelfRel());
		return resource;
	}

}
