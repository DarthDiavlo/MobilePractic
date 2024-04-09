package ru.mirea.dyachenkov.cryptoloader;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MyLoader extends AsyncTask<String, Void, String> {
    private Context context;
    private String AESkey = "YourKeyHere";
    private static final String AES = "AES";

    public MyLoader(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String decryptedString = null;
        try {
            decryptedString = decrypt(strings[0], AESkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedString;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    private String decrypt(String outputString, String password) throws Exception {
        SecretKeySpec key = generateKey(password);
        Cipher c = Cipher.getInstance(AES);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(outputString);
        byte[] decValue = c.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private SecretKeySpec generateKey(String password) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes("UTF-8");
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        return secretKeySpec;
    }
}
