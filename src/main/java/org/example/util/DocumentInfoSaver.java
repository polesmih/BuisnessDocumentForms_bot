package org.example.util;

import org.example.bot.settings.ConfigSettings;
import org.example.dao.DocumentDAO;
import org.example.entity.DocumentInfo;

import java.util.List;

public class DocumentInfoSaver {
    private final String ROOT;
    private final DocumentDAO documentDAO;
    private static final String ACTS = "acts/";
    private static final String CLAIMS = "claims/";
    private static final String CONTRACTS = "contracts/";
    private static final String CUSTOMER = "customer/";
    private static final String PROXY = "proxy/";
    private static final String VOUCHERS = "vouchers/";


    public DocumentInfoSaver(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
        this.ROOT = ConfigSettings.getInstance().getDocPath();
    }

    public void saveDocumentInfo(List<DocumentInfo> list) {
        pathUpdater(list);
        documentDAO.saveAll(list);
    }

    private void pathUpdater(List<DocumentInfo> list) {
        list.forEach(docInfo -> {
            switch (docInfo.getDocType()) {
                case "Акты":
                    docInfo.setDocPath(ROOT + ACTS + docInfo.getDocPath());
                    break;

                case "Судебные документы":
                    docInfo.setDocPath(ROOT + CLAIMS + docInfo.getDocPath());
                    break;

                case "Договоры":
                    docInfo.setDocPath(ROOT + CONTRACTS + docInfo.getDocPath());
                    break;

                case "Защита прав потребителей":
                    docInfo.setDocPath(ROOT + CUSTOMER + docInfo.getDocPath());
                    break;

                case "Доверенности":
                    docInfo.setDocPath(ROOT + PROXY + docInfo.getDocPath());
                    break;

                case "Расписки":
                    docInfo.setDocPath(ROOT + VOUCHERS + docInfo.getDocPath());
            }
        });
    }
}