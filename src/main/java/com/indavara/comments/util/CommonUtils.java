package com.indavara.comments.util;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CommonUtils {


    public static boolean isNotEmptyStrings(List<String> stringList) {
        return !CollectionUtils.isEmpty(stringList);
    }

    public static String getBasicAuthorizationToken(String userName, String password) {
        String token = userName + ":" + password;
        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(getBasicAuthorizationToken("admin", "admin"));
    }


}
