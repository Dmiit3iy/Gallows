package model;

import constant.Constants;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    @NonNull
    private String username;
    private int lives = Constants.LIFE_LEVEL;

    public int minusLive() {
        return --lives;
    }
}
