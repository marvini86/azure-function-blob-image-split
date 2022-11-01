package br.com.wzapps.fnimagesplit.handler;

import br.com.wzapps.fnimagesplit.domain.model.FileBlob;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.*;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

public class ThumbnailHandler extends FunctionInvoker<FileBlob, Object> {

    @FunctionName("func-split-image")
    public void execute(
            @BlobTrigger(name = "file", path = "postimages/{name}", connection = "StorageConnectString") byte[] content,
            @BindingName("name") String filename,
            ExecutionContext context) {

          context.getLogger().info("Name: " + filename + " Size: " + content.length + " bytes");

          handleRequest(new FileBlob(filename, content), context);

    }

}
