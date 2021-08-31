package com.helpers.utils;

import com.helpers.constants.Constants;
import com.helpers.write.Report;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class FilesUtils {

    private final static Logger logger = Logger.getLogger(FilesUtils.class.getName());

    public static boolean fileExist(String path){
        try{
            if(createFolderIfNotExist()){
                return new File(path).exists();
            }
            return false;

        }catch (NullPointerException e ){
            logger.warning("ERROR: " + e.getMessage());
        }
        return false;
    }

    public static boolean createFolderIfNotExist(){
        String path = StringUtils.concatenate( System.getProperty(Constants.USER_DIR),"/report");

        File pathAsFile = new File(path);

        if (!Files.exists(Paths.get(path))) {
            return pathAsFile.mkdir();
        }

        return true;
    }
}
