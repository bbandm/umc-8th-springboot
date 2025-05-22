package umc.week7.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.week7.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}