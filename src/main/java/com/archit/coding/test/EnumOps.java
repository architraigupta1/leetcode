package com.archit.coding.test;

public class EnumOps {
  public enum RequestType {
    RELEASE,
    REVERSE_RELEASE,
    TRANSFER;
  }

  public static void main(String[] args) {
    System.out.print(RequestType.RELEASE.name());
  }
}
