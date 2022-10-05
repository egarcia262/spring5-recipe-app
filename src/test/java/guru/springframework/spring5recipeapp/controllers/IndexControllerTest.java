package guru.springframework.spring5recipeapp.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import guru.springframework.spring5recipeapp.services.RecipeService;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {

	IndexController indexController;
	
	@Mock
	RecipeService recipeService;
	
	@Mock
    Model model;
	
	@BeforeEach
    void setUp() {
		indexController = new IndexController(recipeService);
	}
	
	@Test
	void testGetIndexPage() {
		
		String indexString = "";
		
		indexString = indexController.getIndexPage(model);
		
        assertEquals(indexString, "index");
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
	}

}
