package com.revature.data.utils;

import java.util.Locale;
import java.util.ResourceBundle;



import org.apache.log4j.Logger;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

public class DataUtils {
  private static Logger logger = Logger.getLogger(DataUtils.class);

  private DataUtils() {}

  public static String getPropertyMessage(String key) {
    String msg = key;
    try {
      ResourceBundle resourceBundle =
          ResourceBundle.getBundle("com.revature.data.utils.dataMessage", new Locale("en"));
      msg = resourceBundle.getString(key);
      logger.info(String.format("Key retrived sucessfully, for the key %s", key));
    } catch (NullPointerException e) {
      logger.error(String.format("Key not found , the key is", key), e);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return msg;
  }

//	public static String encryptPassword(String password) {
//		String hashedPassword = null;
//		try {
//			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			hashedPassword = passwordEncoder.encode(password);
//			logger.info(String.format("Password encrypted successfully, %s", hashedPassword));
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//		return hashedPassword;
//	}
//
//	public static Boolean checkPassword(String password, String dbPassword) {
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		if (passwordEncoder.matches(password, dbPassword)) {
//			logger.info(String.format("Password matches"));
//			return true;
//		} else {
//			logger.info(String.format("Password not matches"));
//			return false;
//		}
//	}
}
