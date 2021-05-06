package javaPractice.simple.fileOperate.image.captcha;

import java.awt.*;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;

import static javaPractice.simple.fileOperate.image.captcha.Randoms.num;


/**
 * @Author: zrw
 * @Date: 2021/4/9 10:02
 */
public abstract class Captcha {
    /**
     * 字体
     */
    protected Font font = new Font("Verdana", Font.ITALIC | Font.BOLD, 28);
    /**
     * 验证码随机字符长度
     */
    protected int len = 4;
    /**
     * 验证码显示跨度
     */
    protected int width = 120;
    /**
     * 验证码显示高度
     */
    protected int height = 32;
    /**
     * 随机字符串
     */
    private String chars = null;

    /**
     * 生成随机字符数组
     *
     * @return 字符数组
     */
    protected char[] alphas() {
//        char[] cs = new char[len];
//        for (int i = 0; i < len; i++) {
//            cs[i] = alpha();
//        }
//        chars = new String(cs);
//        return cs;
        Random random = new Random();
        char[] chs1 = {'2', '3', '4', '5', '6', '7', '8', '9'};
        char[] chs = Arrays.copyOf(chs1, chs1.length + 26);
        char[] chs2 = new char[len];
        for (int i = 0; i < 26; i++) {
            chs[chs1.length + i] = (char) ('A' + i);
        }
        int i = 0;
        while (true) {
            if (i < len) {
                chs2[i] = chs[random.nextInt(chs.length)];
                i++;
            } else {
                break;
            }
        }
        chars = new String(chs2);
        return chs2;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 给定范围获得随机颜色
     *
     * @return Color 随机颜色
     */
    protected Color color(int fc, int bc) {
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + num(bc - fc);
        int g = fc + num(bc - fc);
        int b = fc + num(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * 验证码输出,抽象方法，由子类实现
     *
     * @param os 输出流
     */
    public abstract void out(OutputStream os);

    /**
     * 获取随机字符串
     *
     * @return string
     */
    public String text() {
        return chars;
    }
}
