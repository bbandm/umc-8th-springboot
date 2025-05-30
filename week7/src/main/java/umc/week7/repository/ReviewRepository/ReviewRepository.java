package umc.week7.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.week7.domain.Member;
import umc.week7.domain.Review;
import umc.week7.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findByMemberId(Long memberId, Pageable pageable);
    Object save(Review review);
}
