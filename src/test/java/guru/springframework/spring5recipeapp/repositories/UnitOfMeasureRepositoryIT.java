package guru.springframework.spring5recipeapp.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import guru.springframework.spring5recipeapp.bootstrap.RecipeBootstrap;
import guru.springframework.spring5recipeapp.domain.UnitOfMeasure;

@ExtendWith(MockitoExtension.class)
// @DataJpaTest
@DataMongoTest
class UnitOfMeasureRepositoryIT {
	
	@Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;
	
	@Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RecipeRepository recipeRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		recipeRepository.deleteAll();
        unitOfMeasureRepository.deleteAll();
        categoryRepository.deleteAll();

        RecipeBootstrap recipeBootstrap = new RecipeBootstrap(categoryRepository, recipeRepository, unitOfMeasureRepository);

        recipeBootstrap.onApplicationEvent(null);
	}

	@Test
	public void findByDescription() throws Exception {

        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() throws Exception {

        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", uomOptional.get().getDescription());
    }

}
