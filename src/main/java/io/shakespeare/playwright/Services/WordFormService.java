package io.shakespeare.playwright.Services;

import java.util.List;

import io.shakespeare.playwright.dto.WordFormDTO;

public interface WordFormService {

	List<WordFormDTO> getAllWordForms();

	WordFormDTO getOneWordForm(int id);

	WordFormDTO addWordForm(WordFormDTO wordFormDTO);

	Boolean deleteWordForm(Integer id);

	WordFormDTO updateWordForm(Integer id, WordFormDTO wordFormDTO) throws Exception;
	
	List<WordFormDTO> getWordFormByText(String text);

	List<WordFormDTO> findPagedWordForms(int page, int size);

}
