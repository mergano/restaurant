package com.kiyoshi.core;

import static java.awt.Toolkit.getDefaultToolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldLimit extends PlainDocument {

    private final int limit;

    public TextFieldLimit(int limitation) {
        this.limit = limitation;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
        if (str.isEmpty()) {
        } else if (getLength() + str.length() <= limit) {
            super.insertString(offset, str, set);
        } else {
            getDefaultToolkit().beep();
        }
    }
    \
}
