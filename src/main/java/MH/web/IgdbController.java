package MH.web;

import MH.domain.restaurant.Restaurant;
import MH.service.RestaurantService;
import MH.web.dto.PositionDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		List<PositionDto> positions = restaurantService.getPosition(data);
		System.out.println(positions);
		model.addAttribute("data", data);
		model.addAttribute("positions", positions);
		return "restaurant";
	}
}
