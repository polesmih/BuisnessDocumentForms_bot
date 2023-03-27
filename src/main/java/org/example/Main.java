package org.example;

import org.example.bot.Bot;
import org.example.bot.settings.Logger;
import org.example.dao.DocumentDAO;
import org.example.dao.imp.DocumentDAOImp;
import org.example.util.DocumentInfoSaver;
import org.example.util.ParserJson;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();

        try {
            Bot bot = new Bot();
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);
            bot.init();
            saveDocInfoToDb();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        logger.log("Бот запущен!");
    }

    private static void saveDocInfoToDb() {
        ParserJson parser = new ParserJson();
        DocumentDAO documentDAO = new DocumentDAOImp();
        DocumentInfoSaver saver = new DocumentInfoSaver(documentDAO);

        var docInfoList = parser.getDocumentInfoList();
        saver.saveDocumentInfo(docInfoList);
    }
}