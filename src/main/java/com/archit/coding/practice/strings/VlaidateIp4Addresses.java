package com.archit.coding.practice.strings;

public class VlaidateIp4Addresses {
  public static void main(String[] args) {

  }

  static boolean validateIP(String ip) {
    // your code goes here
    String[] comp = ip.split("\\.");
    if(comp.length != 4) {
      return false;
    }

    for (int i = 0; i < 4; i++) {
      try {
        Integer segment = Integer.valueOf(comp[i]);
        if (segment >= 0 && segment <= 255) {
          continue;
        }
      } catch (Exception ex) {
        return false;
      }

    }

    return true;
  }
}
