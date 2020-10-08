package io.shakespeare.playwright.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.shakespeare.playwright.Services.WordFormService;
import io.shakespeare.playwright.dto.PlaywrightResponseObject;
import io.shakespeare.playwright.dto.WordFormDTO;

@RestController
@RequestMapping(value = "/wordform")
public class WordFormController {

	@Autowired
	WordFormService wordFormService;

	@GetMapping()
	public ResponseEntity<PlaywrightResponseObject<List<WordFormDTO>>> getAllWordForms() {

		List<WordFormDTO> wordFormDTOs = wordFormService.getAllWordForms();
		PlaywrightResponseObject<List<WordFormDTO>> response = new PlaywrightResponseObject(wordFormDTOs,
				"Get all Word Forms", "/wordform");
		return ResponseEntity.ok(response);

	}

	@GetMapping("/getWordForm/{id}")
	public ResponseEntity<PlaywrightResponseObject<WordFormDTO>> getWordForm(@PathVariable("id") int id) {

		WordFormDTO wordForm = wordFormService.getOneWordForm(id);
		PlaywrightResponseObject<WordFormDTO> response = new PlaywrightResponseObject<WordFormDTO>(wordForm,
				"Get one word form", "/wordform");
		return ResponseEntity.ok(response);
	}

	
	@GetMapping("/getWordFormByText/{text}")
	public ResponseEntity<PlaywrightResponseObject<List<WordFormDTO>>> getWordForm(@PathVariable("text") String text) {

		List<WordFormDTO> wordForm = wordFormService.getWordFormByText(text);
		PlaywrightResponseObject<List<WordFormDTO>> response = new PlaywrightResponseObject<List<WordFormDTO>>(wordForm,
				"Get one word form by text", "/wordformByText");
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping
	public ResponseEntity<PlaywrightResponseObject<WordFormDTO>> addWordForm(@RequestBody WordFormDTO wordForm) {

		WordFormDTO savedWord = wordFormService.addWordForm(wordForm);
		PlaywrightResponseObject<WordFormDTO> response = new PlaywrightResponseObject<WordFormDTO>(wordForm,
				"Add one word form", "/wordform");
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/deleteWordForm/{id}")
	public ResponseEntity<PlaywrightResponseObject> deleteWordForm(@PathVariable("id") int id) {
		
		Boolean boo = wordFormService.deleteWordForm(id);
		PlaywrightResponseObject<String> response = new PlaywrightResponseObject<String>("Word deleted",
				"Delete one word form", "/wordform");
		return ResponseEntity.ok(response);
	}

	@PutMapping(value = "/updateWordForm/{id}")
	public ResponseEntity<PlaywrightResponseObject<WordFormDTO>> updateWordForm(@PathVariable("id") int id,
			@RequestBody WordFormDTO wordForm) throws Exception {

		WordFormDTO word = wordFormService.updateWordForm(id, wordForm);
		PlaywrightResponseObject<WordFormDTO> response = new PlaywrightResponseObject<WordFormDTO>(word,
				"Update one word form", "/wordform");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value ="/getPagedResponse")
	public ResponseEntity<PlaywrightResponseObject<List<WordFormDTO>>> getPagedTutorials(
			@RequestParam(required = false) Integer id,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
			){
		
		List<WordFormDTO> pagedWordsDTO = wordFormService.findPagedWordForms(page, size);
		PlaywrightResponseObject<List<WordFormDTO>> response = new PlaywrightResponseObject<List<WordFormDTO>>(pagedWordsDTO,
				"Paged word form", "/getPagedResponse");
		return ResponseEntity.ok(response);
	}

}
