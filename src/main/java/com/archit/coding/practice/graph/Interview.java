package com.archit.coding.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interview {
//  Sample car number
//  AP-12-AJ-1234
//  Map<String, String>  areaToNumber;
//  Map<String, Map<String, String>> districtToArea;
  Map<String, Map<String, Map<String, Map<String, String>>>> stateToDistrict;

  public Interview() {
    this.stateToDistrict = new HashMap<>();
  }

  public static void main(String[] args) {
    Interview interview = new Interview();
    interview.saveCarNumber("AP-12-AJ-1234");
  }

  private boolean saveCarNumber(String input) {
    String [] parts = input.split("-"); //extract parts
    Map<String, Map<String, Map<String, String>>> districtToArea = stateToDistrict.getOrDefault(parts[0], new HashMap<>());
    Map<String, Map<String, String>>  areaToNumber = districtToArea.getOrDefault(parts[1], new HashMap<>());
    Map<String, String> numbers = areaToNumber.getOrDefault(parts[2], new HashMap<>());
    if (!numbers.containsKey(parts[3])) {
      numbers.put(parts[3], parts[3]);
      return true;
    }

    return false;
  }

  private List<String> fetchNumberPlates(String input) {
    String [] parts = input.split("-"); //extract parts
    int n = parts.length;
    final Map<String, Map<String, Map<String, String>>> districToArea = this.stateToDistrict.get(parts[0]);
    final Map<String, Map<String, String>> areaToNumber;
    switch (n) {
      case 4:  //exact number plate
        areaToNumber = districToArea.get(parts[1]);
        String numberPlate = areaToNumber.get(parts[2]).get(parts[3]);
        List<String> result = new ArrayList<>();
        result.add(numberPlate);
        return  result;

      case 3: //state + distrct + area
        areaToNumber = districToArea.get(parts[1]);
        return getAllAreaCodePlates(parts[0], parts[1], areaToNumber, parts[2]);

      case 2: //state + distict
        return getAllStateDistrictAreaLevelCodePlates(parts[0], districToArea, parts[1]);

      case 1: //all state plates
        return getAllStateCodePlates(parts[0]);

      default: new ArrayList<>();
    }
    return new ArrayList<>();
  }

  private List<String> getAllStateCodePlates(String stateCode) {
    if (!this.stateToDistrict.containsKey(stateCode)) {
      return new ArrayList<>();
    }

    final Map<String, Map<String, Map<String, String>>> districToArea = this.stateToDistrict.get(stateCode);
    List<String> allStateCodePaltes = new ArrayList<>();
    for(String districtCode : districToArea.keySet()) {
      List<String> allDistricCodePlates = this.getAllStateDistrictAreaLevelCodePlates(stateCode, districToArea, districtCode);
      allDistricCodePlates.addAll(allDistricCodePlates);
    }

    return allStateCodePaltes;
  }

  private List<String> getAllStateDistrictAreaLevelCodePlates(String stateCode,
                                                              Map<String, Map<String, Map<String, String>>> districToArea,
                                                              String distictCode) {
    final Map<String, Map<String, String>> areaToNumber = districToArea.get(distictCode);
    List<String> allDistrictCodes = new ArrayList<>();
    for(String areaCode : areaToNumber.keySet()) {
      List<String> allAreaCodePlates = this.getAllAreaCodePlates(stateCode, distictCode, areaToNumber, areaCode);
      allDistrictCodes.addAll(allAreaCodePlates);
    }

    return allDistrictCodes;
  }

  private List<String> getAllAreaCodePlates(String stateCode, String distictCode, Map<String, Map<String, String>> areaToNumber, String areaCode) {
    final Map<String, String> numberPlatesMap = areaToNumber.get(areaCode);
    List<String> numberPlates = new ArrayList<>();
    for (String numberPlate : numberPlatesMap.keySet()) {
      StringBuilder sb = new StringBuilder();
      sb.append(stateCode).append("-")
          .append(distictCode).append("-")
          .append(areaCode).append("-")
          .append(numberPlate);
      numberPlates.add(sb.toString());
    }

    return numberPlates;
  }

}

