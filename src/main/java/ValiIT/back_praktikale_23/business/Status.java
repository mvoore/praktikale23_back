package ValiIT.back_praktikale_23.business;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    DELETED("D");

    private final String letter;

    Status(String letter) {

        this.letter = letter;
    }
}
