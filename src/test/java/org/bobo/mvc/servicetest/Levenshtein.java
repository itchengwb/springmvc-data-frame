package org.bobo.mvc.servicetest;

/**
 *
 */
public class Levenshtein {
    /**
     * 用每个字符串的每个字符逐一的去和另外的一个字符串的每个字符比较,相等的就给个得分0，不存在的就给个得分1
     * @param str
     * @param target
     * @return
     */
    private static int compare(String str, String target) {
        int d[][];
        int n = str.length();
        int m = target.length();
        int i;
        int j;
        char ch1;
        char ch2;
        int temp;
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }
        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }
        for (i = 1; i <= n; i++) {
            ch1 = str.charAt(i - 1);
            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

    // 使用三木运算来判定大小
    private static int min(int one, int two, int three) {
        return (one = one < two ? one : two) < three ? one : three;
    }

    // 用d[n][m]除以字符串长度，如果值越大说明相似度越低，值越小说明相似度高
    public static float getSimilarityRatio(String str, String target) {
        return 1 - (float) compare(str, target) / Math.max(str.length(), target.length());
    }

    /**
     * 字符串相似度对比
     * @param args
     */
    public static void main(String[] args) {
        Levenshtein lt = new Levenshtein();
        String str = "【领英中国】赵强邀请您在领英成为好友 https://lnkd.in/dbW6dmT。回N退订";
        String target = "【领英中国】注册成功。请下载和登录领英APP并添加个人资料和人脉，完善您的芝麻信用评估https://lnkd.in/bW*vGCM回复*退订";
        System.out.println("similarityRatio=" + lt.getSimilarityRatio(str, target));
    }
}
