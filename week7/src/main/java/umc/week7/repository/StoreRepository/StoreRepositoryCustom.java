package umc.week7.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import umc.week7.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
