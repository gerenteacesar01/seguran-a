package modelo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class GlicoseJejum {
    private byte[] dadosCriptografados;
    private static final byte[] CHAVE_CRIPTOGRAFIA = "MinhaChaveSecreta".getBytes(StandardCharsets.UTF_8);

    public GlicoseJejum(byte[] dadosCriptografados) {
        this.dadosCriptografados = dadosCriptografados;
    }

    public byte[] getDadosCriptografados() {
        return dadosCriptografados;
    }

    public void setDadosCriptografados(byte[] dadosCriptografados) {
        this.dadosCriptografados = dadosCriptografados;
    }

    public byte[] criptografar() {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(Arrays.copyOf(CHAVE_CRIPTOGRAFIA, 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return cipher.doFinal(dadosCriptografados);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] descriptografar(byte[] dadosCriptografados) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(Arrays.copyOf(CHAVE_CRIPTOGRAFIA, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return cipher.doFinal(dadosCriptografados);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
