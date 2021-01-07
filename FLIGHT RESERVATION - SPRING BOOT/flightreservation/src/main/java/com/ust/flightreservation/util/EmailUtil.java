package com.ust.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
 
 @Autowired
 private JavaMailSender sender;
 
 public void sendItinerary(String toAddress, String filePath) {
  
  MimeMessage msg = sender.createMimeMessage();
  
  try {
   
   MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true);
   msgHelper.setTo(toAddress);
   msgHelper.setSubject("Itinerary for your Flight");
   msgHelper.setText("Please find your itinerary attached");
   msgHelper.addAttachment("Itinerary", new File(filePath));
   sender.send(msg);
   
  }catch(MessagingException e) {
   e.printStackTrace();
  }
  
 }
 
}