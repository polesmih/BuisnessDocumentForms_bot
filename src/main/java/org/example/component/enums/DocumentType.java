package org.example.component.enums;

public enum DocumentType {
    CONTRACT("Договоры"),
    ACT("Акты"),
    PROXY("Доверенности"),
    CLAIM("Судебные документы"),
    VOUCHER("Расписки"),
    CUSTOMER("Защита прав потребителей");

    private final String docType;

    DocumentType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }
}