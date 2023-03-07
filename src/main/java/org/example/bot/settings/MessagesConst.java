package org.example.bot.settings;

import static org.example.bot.settings.CommandConst.*;
import static org.example.bot.settings.EmojiConst.*;

public class MessagesConst {

    public final static String ENTER = "\n";

    public final static String HELLO = "Привет! " + HI + ENTER +
            "Этот бот знает формы некоторых документов, " +
            "которые тебе могут пригодиться." + ENTER +
            "Введи команду " + KEY;

    public final static String DOG_SHELTER = "Хочешь меня отблагодарить? -" + ENTER +
            "помоги Фонду \"Помощь бездомным собакам\" " + DOG + ENTER +
            "\"https://donate.priut.ru\"";

    public final static String CHOOSE = "На появившейся клавиатуре " +
            "выбери нужный вид документов " + DOWN;

    public final static String INFO = "Количество посетителей " + VISIT + " ";

    public final static String MENU = "А теперь просто отправь номер, " +
            "указанный рядом с нужной формой, и она автоматически скачается:" + ENTER;

    public final static String UNKNOWN = "Неизвестный запрос... " + THINKING;

}
