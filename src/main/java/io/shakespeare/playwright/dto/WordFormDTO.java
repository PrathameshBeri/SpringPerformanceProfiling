package io.shakespeare.playwright.dto;

public class WordFormDTO {

	Integer wordFormId;
	String text;
	String phoenetic_text;
	String stem_text;
	Integer occurences;

	public WordFormDTO() {
		super();
	}

	public WordFormDTO(Integer id, String text, String phoenetic_text, String stem_text, Integer occurences) {
		super();
		this.wordFormId = id;
		this.text = text;
		this.phoenetic_text = phoenetic_text;
		this.stem_text = stem_text;
		this.occurences = occurences;
	}

	public Integer getWordFormId() {
		return wordFormId;
	}

	public void setWordFormId(Integer wordFormId) {
		this.wordFormId = wordFormId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPhoenetic_text() {
		return phoenetic_text;
	}

	public void setPhoenetic_text(String phoenetic_text) {
		this.phoenetic_text = phoenetic_text;
	}

	public String getStem_text() {
		return stem_text;
	}

	public void setStem_text(String stem_text) {
		this.stem_text = stem_text;
	}

	public Integer getOccurences() {
		return occurences;
	}

	public void setOccurences(Integer occurences) {
		this.occurences = occurences;
	}

	@Override
	public String toString() {
		return "WordFormDTO [id=" + wordFormId + ", text=" + text + ", phoenetic_text=" + phoenetic_text + ", stem_text="
				+ stem_text + ", occurences=" + occurences + "]";
	}

}
