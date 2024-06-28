package com.xprinter.net;

import java.io.IOException;

/**
 * @Author: Noah @Date: 2024/6/27 17:44 @Description:
 */
public class XPrinterTest {

    public static void main(String[] args) throws IOException{
        //第一个参数是打印机网口IP
        PosUtil pos = new PosUtil("192.168.2.10", 9100, "utf8");

        //初始化打印机
        pos.initPos();

        pos.bold(true);
        pos.printTabSpace(2);
        pos.printWordSpace(1);
        pos.printTextBig(0x10,0x01);
        pos.printText("**测试店铺");

        pos.printLocation(0);
        pos.printTextNewLine("----------------------------------------------");
        pos.bold(false);
        pos.printTextNewLine("订 单 号：1005199");
        pos.printTextNewLine("用 户 名：15712937281");
        pos.printTextNewLine("桌  号：3号桌");
        pos.printTextNewLine("订单状态：订单已确认");
        pos.printTextNewLine("订单日期：2016/2/19 12:34:53");
        pos.printTextNewLine("付 款 人：线下支付（服务员：宝哥）");
        pos.printTextNewLine("服 务 员：1001");
        pos.printTextNewLine("订单备注：不要辣，少盐");
        pos.printLine(2);

        pos.printText("品项");
        pos.printLocation(20, 1);
        pos.printText("单价");
        pos.printLocation(99, 1);
        pos.printWordSpace(1);
        pos.printText("数量");
        pos.printWordSpace(3);
        pos.printText("小计");
        pos.printTextNewLine("----------------------------------------------");
        pos.printLocation(1);
        pos.printLine(2);
        //打印二维码
        pos.qrCode("http://blog.csdn.net/haovip123");

        //切纸
        pos.feedAndCut();

        pos.closeIOAndSocket();
        pos = null;
    }
}
