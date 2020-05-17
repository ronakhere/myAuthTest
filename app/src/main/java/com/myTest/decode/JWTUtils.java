package com.myTest.decode;

import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.io.UnsupportedEncodingException;

/**
 * Created by ronak.b on 17/5/2020.
 */

public class JWTUtils {
     public static void decodeJWT(String EncodeString ) throws Exception {
         String[] splitstr = EncodeString.split("\\.");
         Log.d("","###Header "+ getJSon(splitstr[0]));
         Log.d("","###Payload "+getJSon(splitstr[1]));
     }

      public static String getJSon(String EncodeString) throws UnsupportedEncodingException {
          byte[] decodebyte= Base64.decode(EncodeString,Base64.URL_SAFE);
          return  new String(decodebyte,"UTF-8");
      }
}
