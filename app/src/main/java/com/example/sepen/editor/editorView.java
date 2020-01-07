package com.example.sepen.editor;

public interface editorView {
    void showProgress();
    void hideProgress();
    void onAddSuccess(String message);
    void onAddError(String message);
}
