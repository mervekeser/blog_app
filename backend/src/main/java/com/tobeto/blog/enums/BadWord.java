package com.tobeto.blog.enums;

public enum BadWord {
    BADWORD1("kötü söz"),
    BADWORD2("kötü söz2");

    private final String badWord;
    BadWord(String badWord){
        this.badWord = badWord;
    }

    public String getBadWord() {
        return badWord;
    }

    public static void checkForProfanity(String content) {
        for (BadWord badWord : BadWord.values()) {
            if (content.toLowerCase().contains(badWord.getBadWord())) {
                throw new RuntimeException("Yorum kötü söz içeremez: " + badWord.getBadWord());
            }
        }
    }
}
