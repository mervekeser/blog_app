package com.tobeto.blog.service.constants;

public class Messages {
    public class IdMessages{
        public static final String ID_NOT_NULL = "İd boş geçilemez";
        public static final String ID_NOT_NEGATIVE = "İd negatif olamaz";
    }

    public class PostMessages{
        public static final String TITLE_NOT_BLANK = "Başlık boş bırakılamaz";
        public static final String CONTENT_NOT_BLANK = "İçerik alanı boş bırakılamaz";
        public static final String POST_NOT_FOUND = "Gönderi bulunamadı";

    }

    public class CommentMessages{
        public static final String CONTENT_NOT_BLANK = "Yorum alanı boş bırakılamaz";
        public static final String COMMENT_NOT_FOUND = "Yorum bulunamadı";
    }

    public class  UserMessage{
        public static final String USER_NAME_NOT_BLANK = "İsim alanı boş geçilemez";
        public static final String USER_NAME_ONLY_LETTERS = "İsim alanı sadece harflerden oluşmalıdır.";
        public static final String USER_SURNAME_NOT_BLANK = "Soyisim alanı boş geçilemez";
        public static final String USER_SURNAME_ONLY_LETTERS = "Soyisim alanı sadece harflerden oluşmalıdır.";
        public static final String PHONE_NUMBER_NOT_START_ZERO = "Telefon numarasını başında sıfır olmadan giriniz!.";
        public static final String ENTER_VALID_EMAIL = "Geçerli bir e-posta adresi giriniz .";
        public static final String USER_NOT_FOUND = " nolu id'ye sahip user bulunmamaktadır.";
        public static final String USER_ONLY_LETTERS_REGEX = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$";
    }


    public class GeneralMessage{
        public static final String WRONG_INFORMATION = "Bilgiler hatalı!";
        public static final String REPLACE_ALL_REGEX = "\\s";
        public static final String REPLACE_ALL_REPLACEMENT = "";
        public static final String GSM_REGEX = "^[0-9]{10}$";
    }
}
