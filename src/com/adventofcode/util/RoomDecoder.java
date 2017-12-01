package com.adventofcode.util;

public class RoomDecoder {
    
    private String checksum;
    private String roomNumber;
    
    public int decode(String code) {
        roomNumber = getRoomNumber(code);
        checksum = getChecksum(code);
        return 0;
    }
    
    private String stripCode(String code) {
        String[] seq = code.split("-");
        String last = seq[seq.length - 1];
        code = code.substring(0, code.indexOf(last) - 1);
        code = code.replaceAll("-", "");
        return code;
    }
    
    private String getRoomNumber(String code) {
        String[] seq = code.split("-");
        String last = seq[seq.length - 1];
        String roomNumber = last.substring(0, last.indexOf("["));
        return roomNumber;
    }
    
    private String getChecksum(String code) {
        String checksum = code.substring(code.indexOf("[") + 1, code.length() - 2);
        return checksum;
    }
}
