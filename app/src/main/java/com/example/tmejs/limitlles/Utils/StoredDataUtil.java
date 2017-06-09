package com.example.tmejs.limitlles.Utils;

import android.content.Context;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * Created by Tmejs on 09.06.2017.
 */

public class StoredDataUtil {

    private static final String FILENAME = "logFile";
    public static final String PREFS_NAME = "UserID";


    public static void removeUserID(Context ctx){
        try {
            ctx.deleteFile(FILENAME);
        }catch(Exception e){

        }
    }

    public static boolean checkDoLogDataExist(Context ctx){
        //Read login if saved
        try {
            //Open file
            FileInputStream fis = ctx.openFileInput(FILENAME);
            Scanner scanner = new Scanner(fis);
            //Get id
            Integer aa = scanner.nextInt();
            fis.close();
            if(aa!=null) return true;

        }catch(Exception e){

        }

    return false;
    }


    public static void saveLogedUSerID(Context ctx,Integer id){
        removeUserID(ctx);
        try {
            FileOutputStream fos = ctx.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(id);
            fos.close();
        }catch(Exception e){

        }
    }

    public static Integer getUserID(Context ctx){
        try {
            FileInputStream fis = ctx.openFileInput(FILENAME);
            Scanner scanner = new Scanner(fis);
            //Get id
            Integer aa = scanner.nextInt();
            fis.close();
            if (aa != null) return aa;
            else return null;
        }catch(Exception e)
        {
            return null;
        }
    }

}
