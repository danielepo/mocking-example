/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mockitotest;

/**
 *
 * @author d
 */
public class Mailer1 {

  private final Sender sender;
  private final Logger logger;
  
  public Mailer1() {
    this.sender = new SenderImpl();
    this.logger = new LoggerImpl();
    
  }
  public void sendMail(String message) {
    message = "!"+message+"!";
    try {
      sender.send(message);
    } catch (Exception e) {
      logger.log("Got Exeption");
    }
  }
}
