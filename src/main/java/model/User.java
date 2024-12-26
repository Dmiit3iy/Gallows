package model;

import constant.Constants;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {
    @NonNull
    private String username;
    private int lives = Constants.LIFE_LEVEL;

    public int minusLive() {
        return lives -= 1;
    }
}
