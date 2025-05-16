package umc.week7.domain.enums;

import lombok.Getter;

@Getter
public enum Region {
    SEOUL_MAPO("서울-마포구"),
    SEOUL_GANGNAM("서울-강남구"),
    BUSAN_HAEUNDAE("부산-해운대구");

    private final String label;

    Region(String label) {
        this.label = label;
    }
}