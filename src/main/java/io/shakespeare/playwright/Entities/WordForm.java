package io.shakespeare.playwright.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "wordform")
public class WordForm implements Serializable {

	private static final long serialVersionUID = 1324322222L;

	@Id
	@GeneratedValue
	@Column(name = "wordformid")
	private Integer wordFormId;

	@Column(name = "plaintext")
	private String text;

	@Column(name = "phonetictext")
	private String ptext;

	@Column(name = "stemtext")
	private String stext;

	@Column(name = "occurences")
	private Integer occurences;

	public WordForm() {
		super();
	}

	public WordForm(String text, String ptext, String stext, int occurences) {
		super();
		this.text = text;
		this.ptext = ptext;
		this.stext = stext;
		this.occurences = occurences;
	}


	public Integer getWordFormId() {
		return wordFormId;
	}

	public void setWordFormId(Integer wordFormId) {
		this.wordFormId = wordFormId;
	}

	public void setOccurences(Integer occurences) {
		this.occurences = occurences;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPtext() {
		return ptext;
	}

	public void setPtext(String ptext) {
		this.ptext = ptext;
	}

	public String getStext() {
		return stext;
	}

	public void setStext(String stext) {
		this.stext = stext;
	}

	public int getOccurences() {
		return occurences;
	}

	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}

	@Override
	public String toString() {
		return "WordForm [id=" + wordFormId + ", text=" + text + ", ptext=" + ptext + ", stext=" + stext + ", occurences="
				+ occurences + "]";
	}

}
