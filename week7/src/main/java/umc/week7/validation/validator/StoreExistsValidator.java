package umc.week7.validation.validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.week7.validation.annotation.StoreExists;
import umc.week7.repository.StoreRepository.*;

@RequiredArgsConstructor
@Component
public class StoreExistsValidator implements ConstraintValidator<StoreExists, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) return false;  // null일 경우 유효하지 않음
        return storeRepository.existsById(storeId);
    }
}