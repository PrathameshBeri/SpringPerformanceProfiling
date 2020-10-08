package io.shakespeare.playwright.utilities;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import io.shakespeare.playwright.Entities.WordForm;
import io.shakespeare.playwright.dto.WordFormDTO;



@Mapper(componentModel = "spring")
@Component
public interface WordFormMapper {

	@Mapping(source = "wordFormId", target = "wordFormId")
	@Mapping(source = "text", target = "text")
	@Mapping(source = "ptext", target = "phoenetic_text")
	@Mapping(source = "stext", target = "stem_text")
	WordFormDTO toWordFormDTO(WordForm wordForm);

	List<WordFormDTO> toWordFormDTOList(List<WordForm> wordForms);

	
	@InheritInverseConfiguration
	WordForm toWordForm(WordFormDTO wordFormDTO);

}
