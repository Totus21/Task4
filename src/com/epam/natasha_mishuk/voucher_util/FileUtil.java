package com.epam.natasha_mishuk.voucher_util;

import com.epam.natasha_mishuk.available_option.VoucherType;
import com.epam.natasha_mishuk.voucher_exception.NoVoucherParamsInFileException;
import com.epam.natasha_mishuk.voucher_util.FileParameter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileUtil {


   public List<String> readVoucherInitialParametersFromFile(FileParameter localFile)  {

        File objectFile = new File(FileParameter.ROOT_DIR + localFile.getFileName());
        List<String> voucherInitializingOptions = new ArrayList<>();

        try {
            BufferedReader objectReaderNumberOfLines = new BufferedReader(new FileReader(objectFile.getAbsoluteFile()));
            BufferedReader objectBufferedReader = new BufferedReader(new FileReader(objectFile.getAbsoluteFile()));


            try {
                String stringFromFile;

                while ((stringFromFile=objectReaderNumberOfLines.readLine()) != null) {
                    voucherInitializingOptions.add(stringFromFile);
                }


            }
            finally {
                objectBufferedReader.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        return voucherInitializingOptions;


    }

}
