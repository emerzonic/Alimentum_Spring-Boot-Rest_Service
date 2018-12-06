package alimentum.alimentum.controller;

import alimentum.alimentum.service.APIService;
import alimentum.alimentum.util.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RecipeController {
  private APIService apiService;


  @Autowired
  public RecipeController(APIService apiService) {
    this.apiService = apiService;
  }

  @GetMapping("/searchByCategory/{category}")
  private List<Meal> searchByCategory(@PathVariable String category){
    final String uri = "https://www.themealdb.com/api/json/v1/1/filter.php?c=" + category;
    return apiService.getRecipes(uri);
  }

  @GetMapping("/searchByName/{name}")
  private List<Meal> searchByName(@PathVariable String name){
    final String uri = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + name;
    return apiService.getRecipes(uri);

  }

  @GetMapping("/searchByRecipeId/{recipeId}")
  private List<Meal> searchByRecipeId(@PathVariable String recipeId){
    final String uri = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + recipeId;
    return apiService.getRecipes(uri);

  }

  @PostMapping("/search")
  private List<Meal> searchRecipes(@RequestParam(defaultValue = "") String searchTerm){
    final String uri = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + searchTerm;
    return apiService.getRecipes(uri);

  }

}
