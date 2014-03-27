/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mockitotest;

import java.util.List;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;
/**
 *
 * @author d
 */

public class MailerTest extends TestCase {
  
  public MailerTest(String testName) {
    super(testName);
  }
  public void testSendsMail(){
    SenderImpl sender = new SenderImpl();
    LoggerImpl logger = new LoggerImpl();
    Mailer mailer = new Mailer(sender, logger);
    mailer.sendMail("Hello, World");
    assertTrue(sender.string.equals("!Hello, World!"));
  }
  public void testWritesLogOnException() {
    SenderImpl sender = new SenderImpl();
    LoggerImpl logger = new LoggerImpl();
    Mailer mailer = new Mailer(sender, logger);
    sender.shouldThrow = true;
    mailer.sendMail("Hello, World");
    assertTrue(logger.message.equals("Got Exeption"));
  }
  public void testSendsMailAutoMock() {
    Sender sender = mock(Sender.class);
    Logger logger = mock(Logger.class);
    
    Mailer mailer = new Mailer(sender, logger);
    mailer.sendMail("Hello, World");
    
    verify(sender).send("!Hello, World!");
  }
  public void testWritesLogOnExceptionAutoMock() {
    Sender sender = mock(Sender.class);
    Logger logger = mock(Logger.class);
    doThrow(new RuntimeException()).when(sender).send(anyString());
    Mailer mailer = new Mailer(sender, logger);
    mailer.sendMail("Hello, World");
    
    logger.log("Got Exeption");
  }
  
}
