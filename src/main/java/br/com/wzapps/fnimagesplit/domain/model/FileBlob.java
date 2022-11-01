package br.com.wzapps.fnimagesplit.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileBlob {
    private String fileName;
    private byte[] array;

}
