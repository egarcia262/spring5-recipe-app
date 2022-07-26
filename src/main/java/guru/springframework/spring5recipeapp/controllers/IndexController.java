package guru.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5recipeapp.services.RecipeService;
import guru.springframework.spring5recipeapp.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
    	log.debug("I'm in the IndexController");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
