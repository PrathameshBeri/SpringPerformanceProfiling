package io.shakespeare.playwright.Services.Implementations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.shakespeare.playwright.Entities.WordForm;
import io.shakespeare.playwright.Repositories.WordFormRepository;
import io.shakespeare.playwright.Services.WordFormService;
import io.shakespeare.playwright.dto.WordFormDTO;
import io.shakespeare.playwright.utilities.WordFormMapper;
import io.shakespeare.playwright.utilities.Exceptions.EntityNotFoundException;


@Service
public class WordFormServiceImpl implements WordFormService {
	
	private static final Logger logger = LoggerFactory.getLogger(WordFormServiceImpl.class);
	
	@Autowired
	WordFormRepository wordFormRepository;

	@Autowired
	WordFormMapper wordFormMapper;

	@Override
	public List<WordFormDTO> getAllWordForms() {
		// TODO Auto-generated method stub
		List<WordForm> allWordForms = wordFormRepository.findAll();
		return wordFormMapper.toWordFormDTOList(allWordForms);
	}

	@Override
	public WordFormDTO addWordForm(WordFormDTO wordFormDTO) {
		// TODO Auto-generated method stub
		WordForm wf = wordFormMapper.toWordForm(wordFormDTO);
		WordForm savedWordForm = wordFormRepository.save(wf);
		return wordFormMapper.toWordFormDTO(savedWordForm);
	}

	@Override
	public Boolean deleteWordForm(Integer id) {
		// TODO Auto-generated method stub
		try {
			wordFormRepository.deleteById(id);
		} catch (Exception e) {
			
			throw new EntityNotFoundException("Word form to delete not found");
		}

		return true;
	}

	@Override
	public WordFormDTO updateWordForm(Integer id, WordFormDTO wordFormDTO) throws Exception {
		// TODO Auto-generated method stub
		WordForm wordForm = wordFormMapper.toWordForm(wordFormDTO);
		if (wordFormRepository.existsById(id)) {
			wordForm.setWordFormId(id);
			WordForm savedWordForm = wordFormRepository.save(wordForm);
			return wordFormMapper.toWordFormDTO(savedWordForm);
		} else {
			throw new EntityNotFoundException("Word ID not found");
		}

	}

	@Override
	public WordFormDTO getOneWordForm(int id) {
		// TODO Auto-generated method stub
		WordForm wordForm = wordFormRepository.findById(id).get();
		logger.debug(wordForm.toString());
		return wordFormMapper.toWordFormDTO(wordForm);
	}

	@Override
	public List<WordFormDTO> getWordFormByText(String text) {
		// TODO Auto-generated method stub
		List<WordForm> wordsByText = wordFormRepository.findByTextLike(text);
		List<WordFormDTO> wordsByTextDTO = wordFormMapper.toWordFormDTOList(wordsByText);
		return wordsByTextDTO;
	}

	@Override
	public List<WordFormDTO> findPagedWordForms(int page, int size) {
		Pageable paging = PageRequest.of(page, size);
		Page<WordForm> words = wordFormRepository.findAll(paging);
		List<WordForm> wordForms = words.getContent();
		return wordFormMapper.toWordFormDTOList(wordForms);
	}

}
