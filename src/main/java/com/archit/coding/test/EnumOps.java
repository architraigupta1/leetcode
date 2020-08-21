package com.archit.coding.test;

public class EnumOps {
  public enum RequestType {
    RELEASE,
    REVERSE_RELEASE,
    A,
    B,
    TRANSFER;
  }

  public static void main(String[] args) {
    System.out.print(RequestType.RELEASE.name());
    RequestType r = RequestType.TRANSFER;
    switch(r) {
      case REVERSE_RELEASE:
        System.out.println("reverse_release");
        break;
      case RELEASE:
        System.out.println("release");
        break;
      case TRANSFER:
        System.out.println("transfer");
        break;
    }
  }
}
