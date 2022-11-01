package br.com.wzapps.fnimagesplit.service;

import br.com.wzapps.fnimagesplit.domain.model.FileBlob;

public interface ImageService {
    void sendImageToStorage(FileBlob file);
}
