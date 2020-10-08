package io.shakespeare.playwright.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.shakespeare.playwright.Entities.WordForm;

@Repository
public interface WordFormRepository extends JpaRepository<WordForm, Integer> {

	List<WordForm> findByTextLike(String text);
	
	Page<WordForm> findWordFormBy(Integer wordFormId, Pageable pageable);
}
