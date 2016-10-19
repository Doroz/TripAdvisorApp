package com.example.usuario.tripadvisorapp;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 17/05/2016.
 */
public class PermissionUtils {

    //Solicita as permissões
    public static boolean validate(Activity activity, int requestCode, String... permissions){
        List<String> list = new ArrayList<String>();
        for (String permission : permissions){
            //Valida permissão
            boolean ok = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
            if (!ok ){
                list.add(permission);
            }
        }
        if (list.isEmpty()){
            //Se tudo estiver ok, retorna true
            return true;
        }

        //Lista de permissões que faltam acesso.
        String[] newPermissions = new String[list.size()];
        list.toArray(newPermissions);

        //Solicita as permissões que faltam
        ActivityCompat.requestPermissions(activity, newPermissions, 1);

        return false;
    }
}
