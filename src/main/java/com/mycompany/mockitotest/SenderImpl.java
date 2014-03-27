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
class SenderImpl implements Sender {
  public String string;
  public boolean shouldThrow = false;
  public void send(String msg) {
    if(!shouldThrow){
      string = msg;
    }else{
      throw new RuntimeException("Got Exeption");
    }
  }
  
}
