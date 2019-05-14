package com.company;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String version = "";

        // counter initializer
        int first = 0;
        int second = 0;
        int third = 0;
        int snapshot = 0;
        //-------Start of SHA-256-----
        HashSet<String> set = new HashSet<>();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(version.getBytes(StandardCharsets.UTF_8));
        byte[] shortHash = Arrays.copyOfRange(hash, 0,3);
        //-------END of SHA-256--------
        // ???? dont know if needed
        byte[] encodedBytes = Base64.getUrlEncoder().encode(shortHash);
        // ????
        int counter = 0;


        while (set.add(DatatypeConverter.printBase64Binary(shortHash))) {
            counter++;
            version = first + "." + second + "." + third + ((snapshot == 0) ? "-SNAPSHOT" : "");
            hash = digest.digest(version.getBytes(StandardCharsets.UTF_8));
            shortHash = Arrays.copyOfRange(hash, 0, 3);

            //dont know if needed
            //encodedBytes = Base64.getEncoder().encode(foobar2);

            snapshot++;
            if (snapshot == 2) {
                third++;
                snapshot = 0;
                if (third == 100) {
                    second++;
                    third = 0;
                    if (second == 100) {
                        first++;
                        second = 0;
                    }
                }
            }
            //System.out.println(blahfoo);
            /*if (first == 20) {
                break;
            }*/


        }

        System.out.println("Num of versions: -- " + counter);
        System.out.println("Duplicate: -- " + DatatypeConverter.printBase64Binary(shortHash));

        }
}
