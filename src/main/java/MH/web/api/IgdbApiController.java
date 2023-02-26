package MH.web.api;

import MH.service.IgdbService;
import MH.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IgdbApiController {

	private final IgdbService igdbService;

	@PostMapping("api/games/{igdbId}")
	public ResponseEntity<?> getItem(@PathVariable int igdbId) {
		JSONArray Game = igdbService.getGameItem(igdbId);
		JSONArray Image = igdbService.getImageItem(igdbId);
		System.out.println(Image);
		Game.add(Image);
		return new ResponseEntity<>(new CMRespDto<>(1, "성공", Game), HttpStatus.OK);
	}


}
