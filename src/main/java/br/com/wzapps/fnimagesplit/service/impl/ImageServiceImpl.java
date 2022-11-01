package br.com.wzapps.fnimagesplit.service.impl;

import br.com.wzapps.fnimagesplit.domain.model.FileBlob;
import br.com.wzapps.fnimagesplit.service.ImageService;
import com.azure.storage.blob.BlobServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private BlobServiceClient blobServiceClient;
    private static final String CONTAINER = "postimagesthumb";

    @Override
    public void sendImageToStorage(FileBlob file){
        var containerClient = blobServiceClient.getBlobContainerClient(CONTAINER);
        var blob = containerClient.getBlobClient(String.format("thumb_%s", file.getFileName()));
        var array = file.getArray();
        try {
            var imageArray = getThumb(array);
            var byteArray = new ByteArrayInputStream(imageArray);
            blob.upload(byteArray, imageArray.length, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] getThumb(byte[] bytes) throws IOException {
        var img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        img.createGraphics().drawImage(ImageIO.read(new ByteArrayInputStream(bytes)).getScaledInstance(100, 100, Image.SCALE_SMOOTH),0,0,null);
        var baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        return baos.toByteArray();
    }
}
