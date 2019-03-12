package com.litbo.hospital.common.utils.poi;

import java.io.*;

public class ChangeFile {

    public static void changeFile(String yFile,String zFile) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(yFile);
        FileOutputStream fos = new FileOutputStream(zFile);

        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = fis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fis.close();
        fos.close();
      /*  File file = new File(yFile);
        file.delete();*/

    }

    public static boolean deleteDir(String path){
        File file = new File(path);

        String[] content = file.list();
        for (String name : content) {
            File tmp = new File(path,name);
            if(!tmp.exists()){
                return false;
            }
            tmp.delete();
        }

        return true;

    }
}
