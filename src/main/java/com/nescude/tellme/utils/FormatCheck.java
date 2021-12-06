package com.nescude.tellme.utils;

public class FormatCheck {
    
    private static final String[] FC_LINK = {
        "http",".com","www.",".org",".net",".co"
    };

    public static boolean check(String ... strings){
        for ( String string : strings ){
            for (String s : FC_LINK){
                if (string.contains(s))
                    return true;
            }
        }
        return false;
    }
}
