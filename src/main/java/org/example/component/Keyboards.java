package org.example.component;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Arrays;

import static org.example.component.enums.DocumentType.*;

public class Keyboards {
    public static ReplyKeyboardMarkup mainKeyboard() {
        var row1 = new KeyboardRow();
        row1.add(CONTRACT.getDocType());
        row1.add(PROXY.getDocType());

        var row2 = new KeyboardRow();
        row2.add(CLAIM.getDocType());
        row2.add(ACT.getDocType());
        row2.add(VOUCHER.getDocType());

        var row3 = new KeyboardRow();
        row3.add(CUSTOMER.getDocType());

        return ReplyKeyboardMarkup.builder()
                .keyboard(Arrays.asList(row1, row2, row3))
                .resizeKeyboard(true)
                .build();
    }
}