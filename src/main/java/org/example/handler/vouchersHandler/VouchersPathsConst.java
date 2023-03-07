package org.example.handler.vouchersHandler;

import static org.example.bot.settings.EmojiConst.*;
import static org.example.bot.settings.MessagesConst.*;

public class VouchersPathsConst {

    public final static String VOUCHER_MENU = MENU +
            CLIP + " 31" + " - За оплату авто" + ENTER +
            CLIP + " 32" + " - За получение денег" + ENTER +
            CLIP + " 33" + " - За получение документов" + ENTER +
            CLIP + " 34" + " - За получение трудовой книжки" + ENTER +
            CLIP + " 35" + " - Сохранная расписка" + ENTER;

    public final static String ROOT = "/root/docBot/src/main/resources/files/vouchers/";
    public final static String THIRTY_ONE = ROOT + "Расписка продавца за оплату ТС.docx";
    public final static String THIRTY_TWO = ROOT + "Расписка в получении денег (общая).docx";
    public final static String THIRTY_THREE = ROOT + "Расписка в получении документов.docx";
    public final static String THIRTY_FOUR = ROOT + "Расписка в получении трудовой книжки при увольнении.docx";
    public final static String THIRTY_FIVE = ROOT + "Сохранная расписка.docx";

}
