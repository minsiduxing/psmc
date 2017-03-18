package priv.guochun.psmc.authentication.license.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class LoadLicense {

	/**
	 * 解密公钥
	 */
	private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCprYj/tkviBqjy00fiXaj+IpKUYQyHzoKdncvc\n"
			+ "jxgodASS592K8kZBqcryOaccdgesmxGDDFcnGv2ZpvjeG0pp/hssXMOAugVgqSUtSPKO3vURrYyw\n"
			+ "eLJPwm+fWpzGWQdtTGr7tkpnuT+oh/sUy1bs1ozPFxkaGGPhJCGtUoYjdQIDAQAB";

	/**
	 * @param file
	 *            文件的绝对路径以及文件名
	 * @return 解密后的字符串
	 * @Description: 从file中加载文件，解密出字符串
	 */
	public static String getDataFromLicense(String file) {
		FileInputStream in = null;
		byte[] bt = null;
		byte[] plain = null;
		try {
			in = new FileInputStream(file);
			bt = new byte[in.available()];
			in.read(bt);
			try {
				plain = decryptByPublicKey(bt, publicKey);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return plain == null ? "" : new String(plain);
	}

	/** */
	/**
	 * <p>
	 * 公钥解密
	 * </p>
	 * 
	 * @param encryptedData
	 *            已加密数据
	 * @param publicKey
	 *            公钥(BASE64编码)
	 * @return
	 * @throws Exception
	 */
	private static byte[] decryptByPublicKey(byte[] encryptedData,
			String publicKey) throws Exception {
		byte[] keyBytes = Base64.decode(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher
						.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher
						.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;
	}

	/** */
	/**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;

}
