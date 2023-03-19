package MH.service;

import MH.domain.restaurant.Restaurant;
import MH.domain.restaurant.RestaurantRepository;
import MH.web.dto.PositionDto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

	private final RestaurantRepository restaurantRepository;

	public List<Restaurant> getData() {
		List<Restaurant> data = restaurantRepository.findAll();
		return data;
	}

	public List<PositionDto> getPosition(List<Restaurant> data) {
		List<PositionDto> positions = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			PositionDto positionDto = new PositionDto();
			positionDto.setId(data.get(i).getId());
			positionDto.setX(data.get(i).getX());
			positionDto.setY(data.get(i).getY());
			String content;
			if(data.get(i).getKakaoUrl() == null) {
				content = String.format("<div style=\"width:180px; background:#dddddd; text-align:center;\"><span style=\"font-weight:bold\">"
						+ "%s</span><br>"
						+ "<a href=\"%s\" style=\"color:green\" target=\"_blank\">네이버 검색</a></div>",
					data.get(i).getName(), data.get(i).getNaverUrl());
			} else {
				content = String.format("<div style=\"width:180px; background:#dddddd; text-align:center;\"><span style=\"font-weight:bold\">"
						+ "%s</span><br>"
						+ "<a href=\"%s\" style=\"color:yellow\" target=\"_blank\">카카오 검색</a><br>"
						+ "<a href=\"%s\" style=\"color:green\" target=\"_blank\">네이버 검색</a></div>",
					data.get(i).getName(), data.get(i).getKakaoUrl(), data.get(i).getNaverUrl());
			}
			positionDto.setContent(content);
			positions.add(positionDto);
		}
		return positions;
	}
}
