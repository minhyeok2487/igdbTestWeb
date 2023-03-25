package MH.web.api;

import MH.service.IgdbService;
import MH.service.RestaurantService;
import MH.web.dto.CMRespDto;
import MH.web.dto.PositionDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestaurantApiController {

	private final RestaurantService restaurantService;

	@GetMapping("api/restaurant")
	public ResponseEntity<?> getPosition() {
		List<PositionDto> positions = restaurantService.getPosition(restaurantService.getData());
		return new ResponseEntity<>(new CMRespDto<>(1, "성공", positions), HttpStatus.OK);
	}


}
