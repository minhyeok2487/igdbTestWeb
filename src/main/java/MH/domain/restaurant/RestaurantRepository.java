package MH.domain.restaurant;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	List<Restaurant> findByXIsNotNullAndYIsNotNull();
}
