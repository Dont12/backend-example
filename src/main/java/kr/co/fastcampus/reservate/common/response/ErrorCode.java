package kr.co.fastcampus.reservate.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    COMMON_ILLEGAL_STATUS(HttpStatus.BAD_REQUEST, "잘못된 상태값입니다."),
    COMMON_INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "요청한 값이 올바르지 않습니다."),
    COMMON_ENTITY_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 엔티티입니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
