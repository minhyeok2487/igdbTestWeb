package MH.web;

import MH.domain.restaurant.Restaurant;
import MH.service.RestaurantService;
import MH.web.dto.PositionDto;
import MH.web.dto.RestaurantDto;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class IgdbController {

	private final RestaurantService restaurantService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/old")
	public String old() {
		return "old";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/restaurant")
	public String restaurant(Model model) {
		List<Restaurant> data = restaurantService.getData();
		List<Restaurant> allData = restaurantService.getAllData();
		List<PositionDto> positions = restaurantService.getPosition(data);
		System.out.println(data.get(0));
		model.addAttribute("data", data);
		model.addAttribute("allData", allData);
		model.addAttribute("positions", positions);
		return "restaurant";
	}

	@GetMapping("/restaurant/editData/{id}")
	public String editData(@PathVariable int id, Model model) {
		Optional<Restaurant> data = restaurantService.getIdData(id);
		model.addAttribute("data", data.get());
		return "editRestaurant";
	}

	@PostMapping("/restaurant/editData/{id}")
	public String editRestaurantData(RestaurantDto restaurantDto, @PathVariable int id) {
		System.out.println(restaurantDto);
		Restaurant restaurant = restaurantService.editData(restaurantDto);
		System.out.println(restaurant.toString());
		return "redirect:/restaurant";
	}
}
