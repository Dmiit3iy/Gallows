package model;

import constant.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class User {
    @NonNull
    private String username;
    private int lives = Constants.LIFE_LEVEL;

    public int minusLive() {
        return lives -= 1;
    }
}
