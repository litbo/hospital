package com.litbo.hospital.supervise.enums;

import com.litbo.hospital.supervise.dao.ZhiduDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class GwZzShProcessConstants {

    @Autowired
    private ZhiduDao zhiduDao;


        /** 当前状态 */
        public static  int PROCESS_CODE = 0;     // 当前状态


        /** 编写 */
        public static final int ZD_SHZT_KEMUBX = 0;
        /** 科室秘书编写 */
        public static final int ZD_SHZT_KSMUXG = 1;

        /** 试用期修改 */
        public static final int ZD_SHZT_SYQXG = 2;




        /** 科长审核 */
        public static final int ZD_SHZT_KESH = 3;

        /** 处长审核 */
        public static final int ZD_SHZT_CZSH = 4;

        /** 试用 */
        public static final int ZD_SHZT_SY = 5;

        /** 备案*/
        public static final int ZD_SHZT_BA = 6;


        public static final Map<Integer, String> SH_PROCESS = new HashMap<Integer, String>();

        static {
            // Head 相关
            SH_PROCESS.put(ZD_SHZT_KEMUBX, "编写");
            SH_PROCESS.put(ZD_SHZT_KSMUXG, "科室秘书编写");
            SH_PROCESS.put(ZD_SHZT_SYQXG, "试用期修改");

            SH_PROCESS.put(ZD_SHZT_KESH, "科长审核");
            SH_PROCESS.put(ZD_SHZT_CZSH, "处长审核");
            SH_PROCESS.put(ZD_SHZT_SY, "试用");
            SH_PROCESS.put(ZD_SHZT_BA, "备案");

        }
        public static void autoSetProcessCode(boolean isTg){

            if (isTg ){
                if((PROCESS_CODE==ZD_SHZT_KEMUBX)||(PROCESS_CODE==ZD_SHZT_KSMUXG)||(PROCESS_CODE==ZD_SHZT_SYQXG)){
                    PROCESS_CODE = ZD_SHZT_KESH;
                }else {
                    PROCESS_CODE++;
                }
            }else {
                if(PROCESS_CODE==ZD_SHZT_KESH||PROCESS_CODE==ZD_SHZT_CZSH||PROCESS_CODE==ZD_SHZT_BA){
                    PROCESS_CODE = ZD_SHZT_KSMUXG;
                }else if(PROCESS_CODE==ZD_SHZT_SY){
                    PROCESS_CODE=ZD_SHZT_SYQXG;
                }
            }
        }

    public static String autoGetProcessName(String dclCzztName, Boolean isTg) {
        Integer code = getCodeByDclName(dclCzztName);
        PROCESS_CODE = code;
        autoSetProcessCode(isTg);
        return SH_PROCESS.get(PROCESS_CODE);
    }

    public static Integer getCodeByDclName(String dclCzztName){
        for(Integer CODE: SH_PROCESS.keySet()){
            if(SH_PROCESS.get(CODE).equals(dclCzztName)){
                return CODE;
            }
        }
        return null;
    }
}
