package com.platform.service;

import com.github.luben.zstd.Zstd;

import javax.enterprise.context.ApplicationScoped;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@ApplicationScoped
public class CompressingService {

    private CompressingService() {
    }

    public byte[] compress(byte[] rawMedia) {
        byte[] compressedMedia = Zstd.compress(rawMedia);

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\root\\PROJECTS\\PYTHON\\TUTORIAL\\images\\test.jpg")) {
            fos.write(compressedMedia);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return compressedMedia;
    }
}
