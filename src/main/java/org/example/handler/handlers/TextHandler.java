package org.example.handler.handlers;

import org.example.handler.AbstractHandler;
import org.example.handler.HandlerContext;
import org.example.service.DocumentService;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.example.bot.settings.StringConst.CLIP;
import static org.example.bot.settings.StringConst.UNKNOWN;

public class TextHandler extends AbstractHandler {
    private final DocumentService documentService;

    public TextHandler(HandlerContext context, DocumentService documentService) {
        super(context);
        this.documentService = documentService;
    }

    @Override
    public void handling(Message message) {
        var userFrom = message.getFrom();
        var text = message.getText();

        try {
            int docIndex = Integer.parseInt(text);
            var docInfo = documentService.getByIndex(docIndex);

            if (docInfo != null) {
                //Это для теста, когда еще нет документов в директории, то просто читаем из базы инфу о документе
//                String builder = "id: " + docInfo.getId() +
//                        "\nindex: " + docInfo.getDocIndex() +
//                        "\nname: " + docInfo.getDocName() +
//                        "\ntype: " + docInfo.getDocType() +
//                        "\ndescription: " + docInfo.getDescription() +
//                        "\ndate: " + docInfo.getDateCreate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
//                        "\npath: " + docInfo.getDocPath();
//
//                executeMessage(userFrom.getId(), builder);

                executeDocument(userFrom.getId(), docInfo);
                return;
            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace();

            String header = "А теперь просто отправь номер, указанный рядом с нужной формой:\n\n";
            String response = docTypeHandler(text);

            if (response != null) {
                executeMessage(userFrom.getId(), header + response);
                return;
            }
        }
        executeMessage(userFrom.getId(), UNKNOWN);
    }

    private String docTypeHandler(String text) {
        var docInfoList = documentService.getAllByType(text);

        if (docInfoList != null && !docInfoList.isEmpty()) {
            StringBuilder builder = new StringBuilder();

            docInfoList.forEach(docInf -> builder.append(CLIP)
                    .append(" ")
                    .append(docInf.getDocIndex())
                    .append(" - ")
                    .append(docInf.getDocName())
                    .append("\n"));

            return builder.toString().trim();
        }
        return null;
    }
}