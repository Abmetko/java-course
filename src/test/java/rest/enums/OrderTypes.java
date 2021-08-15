package rest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderTypes {

    OPENED(0),
    CLOSED(1);

    private final int type;
}