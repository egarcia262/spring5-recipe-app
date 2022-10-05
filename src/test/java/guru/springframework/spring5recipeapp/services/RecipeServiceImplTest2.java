package guru.springframework.spring5recipeapp.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.spring5recipeapp.domain.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest2 {
 
    RecipeServiceImpl recipeService;
 
    @Mock
    RecipeRepository recipeRepository;
    
    @BeforeEach
    void setUp() {
        recipeService = new RecipeServiceImpl(recipeRepository);
    }
 
    @Test
    void getRecipes() {
 
        Recipe recipe = new Recipe();
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);
 
        when(recipeRepository.findAll()).thenReturn(recipesData);
 
        Set<Recipe> recipes = recipeService.getRecipes();
 
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}
