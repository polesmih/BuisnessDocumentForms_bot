package org.example.handler.customerHandler;

import static org.example.bot.settings.EmojiConst.*;
import static org.example.bot.settings.MessagesConst.*;

public class CustomerPathsConst {

    public final static String CUSTOM_MENU = MENU +
            CLIP + " 48" + " - Иск о защите прав потребителей и моральном ущербе" + ENTER +
            CLIP + " 49" + " - Претензия при дистанционном приобретении товара ненадлежащего качества" + ENTER +
            CLIP + " 50" + " - Претензия о нарушении сроков выполнения работы" + ENTER +
            CLIP + " 51" + " - Иск о взыскании неустойки за просрочку передачи товара" + ENTER +
            CLIP + " 52" + " - Жалоба в Роспотребнадзор" + ENTER +
            CLIP + " 53" + " - Жалоба на постановление о штрафе за платную парковку" + ENTER;

    public final static String ROOT = "/root/docBot/src/main/resources/files/customer/";
    public final static String FORTY_EIGHT = ROOT + "Иск о защите прав потребителей и моральном ущербе.docx";
    public final static String FORTY_NINE = ROOT + "Претензия при приобретении товара ненадлежащего качества дистанционным способом.docx";
    public final static String FIFTY = ROOT + "Претензия о нарушении сроков выполненной работы.docx";
    public final static String FIFTY_ONE = ROOT + "Иск о взыскании неустойки за просрочку передачи товара.docx";
    public final static String FIFTY_TWO = ROOT + "Жалоба в Роспотребнадзор .docx";
    public final static String FIFTY_THREE = ROOT + "Жалоба на постановление о штрафе за платную парковку.docx";

}
