package com.liquorcloud.liquor.offer.no1to10;

public class No4 {

    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。
     */
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("We are happy");
        System.out.println(str);
        System.out.println(trans(str));
    }

    /**
     *
     */
    private static String trans(StringBuffer str){
        if(str==null){
            return "";
        }
        for(int i=str.length()-1;i>0;i--){
            if(str.charAt(i)==' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
}
