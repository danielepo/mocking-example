/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mockitotest;

public class LoggerImpl implements Logger {

  public String message;

  public LoggerImpl() {
    this.message = "";
  }

  public void log(String msg) {
    this.message = msg;
  }

}
