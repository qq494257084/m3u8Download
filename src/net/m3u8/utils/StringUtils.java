package net.m3u8.utils;

import java.math.BigDecimal;

/**
 * @author liyaling
 * @email ts_liyaling@qq.com
 * @date 2019/12/14 16:27
 */

public class StringUtils {

    public static boolean isBlank(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isUrl(String str) {
        if (isEmpty(str))
            return false;
        str = str.trim();
        return str.matches("^(http|https)://.+");
    }

    public static String convertToDownloadSpeed(BigDecimal bigDecimal, int scale) {
        BigDecimal unit = new BigDecimal(1);
        BigDecimal kb = new BigDecimal(1 << 10);
        BigDecimal mb = new BigDecimal(1 << 10).multiply(kb);
        BigDecimal gb = new BigDecimal(1 << 10).multiply(mb);
        BigDecimal tb = new BigDecimal(1 << 10).multiply(gb);
        BigDecimal pb = new BigDecimal(1 << 10).multiply(tb);
        BigDecimal eb = new BigDecimal(1 << 10).multiply(pb);
        if (bigDecimal.divide(kb, scale, BigDecimal.ROUND_HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(unit, scale, BigDecimal.ROUND_HALF_UP).toString() + " B";
        else if (bigDecimal.divide(mb, scale, BigDecimal.ROUND_HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(kb, scale, BigDecimal.ROUND_HALF_UP).toString() + " KB";
        else if (bigDecimal.divide(gb, scale, BigDecimal.ROUND_HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(mb, scale, BigDecimal.ROUND_HALF_UP).toString() + " MB";
        else if (bigDecimal.divide(tb, scale, BigDecimal.ROUND_HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(gb, scale, BigDecimal.ROUND_HALF_UP).toString() + " GB";
        else if (bigDecimal.divide(pb, scale, BigDecimal.ROUND_HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(tb, scale, BigDecimal.ROUND_HALF_UP).toString() + " TB";
        else if (bigDecimal.divide(eb, scale, BigDecimal.ROUND_HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(pb, scale, BigDecimal.ROUND_HALF_UP).toString() + " PB";
        return bigDecimal.divide(eb, scale, BigDecimal.ROUND_HALF_UP).toString() + " EB";
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        if ((len & 1) == 1) {
            s = "0" + s;
            len++;
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

}
