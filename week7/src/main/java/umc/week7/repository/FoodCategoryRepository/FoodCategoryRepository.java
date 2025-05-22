package umc.week7.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.week7.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}