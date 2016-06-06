/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wanchana.servlet.test;

import java.util.Arrays;

/**
 *
 * @author neng
 */
public class Utils {
    
    public static String getFilePath(String path, String fileName) {
        
        System.out.println(path);
        String[] filePath = path.split("/");
        
        return "/" + filePath[1] + "/" + filePath[2] + "/" + fileName;
    }
}
