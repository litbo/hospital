package com.litbo.hospital.common.utils.poi;

public class JudgeExcelVesion {
    /**
     * 通过文件名判断excel版本
     * @param filePath
     * @return
     */
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

}
