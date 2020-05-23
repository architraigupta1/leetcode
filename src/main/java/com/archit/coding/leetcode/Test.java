package com.archit.coding.leetcode;

import java.util.Optional;

public class Test {
  public enum PSP {
    SAP, ADYEN, MIFINITY
  }

  public enum ServiceProvider {
    SAP, ADYEN
  }

  public static class PaymentRoute {
    private PSP psp;

    public PSP getPsp() {
      return psp;
    }
  }

  public static class Request {

    private PaymentRoute paymentRoute;

    public PaymentRoute getPaymentRoute() {
      return paymentRoute;
    }
  }

  public static void main(String[] args) throws Exception {

    Test test = new Test();
    Request request = new Request();
    request.paymentRoute = new PaymentRoute();
    request.paymentRoute.psp = PSP.MIFINITY;
//    ServiceProvider serviceProvider = test.getPsp(request);
//    System.out.println(serviceProvider.name());
    String amt = "4293";
    System.out.println(Long.parseLong(amt));
  }

  public ServiceProvider getPsp(Request request) throws Exception {
    Optional.ofNullable(request.getPaymentRoute())
        .flatMap(route -> Optional.ofNullable(route.getPsp()))
        .filter(psp -> psp == PSP.SAP || psp == PSP.ADYEN)
//        .map(psp -> ServiceProvider.valueOf(psp.name()))
        .orElseThrow(() -> new Exception("paymentRoute.psp not supplied in PayoutRequest"));
    return null;
  }
}
