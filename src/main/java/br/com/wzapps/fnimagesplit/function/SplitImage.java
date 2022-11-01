package br.com.wzapps.fnimagesplit.function;

import br.com.wzapps.fnimagesplit.domain.model.FileBlob;
import br.com.wzapps.fnimagesplit.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class SplitImage implements Consumer<FileBlob> {
    @Autowired
    private ImageService service;

    @Override
    public void accept(FileBlob blob) {
        service.sendImageToStorage(blob);
    }
}
