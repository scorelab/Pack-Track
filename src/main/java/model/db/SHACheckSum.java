package model.db;

import java.security.MessageDigest;

public class SHACheckSum {
 
 private String password;
 
 public SHACheckSum(String password){
  
  this.password = password;
 }
 
 
 public String getEncrValue() throws Exception{
  
  MessageDigest   md = MessageDigest.getInstance("SHA-256");
  //FileInputStream  fis = new FileInputStream(password);
  md.update(password.getBytes());
  
  byte[]  byteData = md.digest();
 
  
  
  StringBuffer   sb = new StringBuffer();
  
  for(int i = 0; i < byteData.length; i++){
   
   sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
  }
  
  
  //convert to hex format
  
  StringBuffer   hexString = new StringBuffer();
  
  for(int i = 0; i < byteData.length; i++){
   
   String  hex = Integer.toHexString(0xff & byteData[i]);
   
   if(hex.length() == 1) hexString.append(0);
   hexString.append(hex);
   
   //hexString.append(Integer.toHexString(0xFF & byteData[i]));
   
   
  }
  
  String conValue = hexString.toString();
  
  return conValue;
  
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 
}
