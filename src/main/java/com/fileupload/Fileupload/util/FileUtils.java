package com.fileupload.Fileupload.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Slf4j
public class FileUtils {

    public static byte[] compressImage(byte[] data){

        log.info("Inside compressImage");

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new  byte[4*1024];
        while (!deflater.finished()){
            int size = deflater.deflate(tmp);
            outputStream.write(tmp,0,size);
        }
        try {
            outputStream.close();
        }catch (Exception ignored){
            return outputStream.toByteArray();
        }
        return outputStream.toByteArray();

    }

    public static byte[] decompressImage(byte[] data){
        log.info("Inside decompressImage");
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try{
            while (!inflater.finished()){
                int count = inflater.inflate(tmp);
                outputStream1.write(tmp,0,count);
            }
            outputStream1.close();
        }catch (Exception ignored){

        }
        return outputStream1.toByteArray();
    }

}
