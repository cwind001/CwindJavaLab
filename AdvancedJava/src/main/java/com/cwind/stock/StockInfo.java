package com.cwind.stock;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Date;

public class StockInfo {
    public static final String SOURCE = "http://hq.sinajs.cn/list=";
    // 股票名称
    public String stock_name;
    // 今日开盘价
    public double begin_price;
    // 昨日收盘价
    public double end_price;
    // 当前价格
    public double current_price;
    // 今日最高价
    public double today_max_price;
    // 今日最低价
    public double today_min_price;
    // 成交股票数量
    public long   total_number;
    // 成交金额
    public double total_price;
    // 买一要买的股数
    public long      buyer_1_number;
    // 买一报价
    public double buyer_1_price;
    // 买二要买的股数
    public long      buyer_2_number;
    // 买二报价
    public double buyer_2_price;
    // 买三要买的股数
    public long      buyer_3_number;
    // 买三报价
    public double buyer_3_price;
    // 买四要买的股数
    public long      buyer_4_number;
    // 买四报价
    public double buyer_4_price;
    // 买五要买的股数
    public long      buyer_5_number;
    // 买五报价
    public double buyer_5_price;
    // 卖一要卖的股数
    public long      seller_1_number;
    // 卖一报价
    public double seller_1_price;
    // 卖二要卖的股数
    public long      seller_2_number;
    // 卖二报价
    public double seller_2_price;
    // 卖三要卖的股数
    public long      seller_3_number;
    // 卖三报价
    public double seller_3_price;
    // 卖四要卖的股数
    public long      seller_4_number;
    // 卖四报价
    public double seller_4_price;
    // 卖五要卖的股数
    public long      seller_5_number;
    // 卖五报价
    public double seller_5_price;
    // 日期
    public Long   time;
    private StockInfo(){}
    public static StockInfo getStockInfo(String stock_num)
    {
        try{
            String input = SOURCE+stock_num;
            String output = "";
            URL url = new URL(input);
            InputStreamReader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));
            char[] cbuf = new char[1024];
            int cnum = -1;
            while((cnum=reader.read(cbuf))!=-1)
            {
                output += new String(cbuf, 0, cnum);
            }            
            output = output.substring(13+stock_num.length());
            output = output.substring(0, output.indexOf("\""));
            String[] infos = output.split(",");
            
            StockInfo stockInfo = new StockInfo();
            stockInfo.stock_name = infos[0];
            stockInfo.begin_price = Double.valueOf(infos[1]);
            stockInfo.end_price = Double.valueOf(infos[2]);
            stockInfo.current_price = Double.valueOf(infos[3]);
            stockInfo.today_max_price = Double.valueOf(infos[4]);
            stockInfo.today_min_price = Double.valueOf(infos[5]);
            stockInfo.total_number = Long.valueOf(infos[8]);
            stockInfo.total_price =  Double.valueOf(infos[9]);
            stockInfo.buyer_1_number = Long.valueOf(infos[10]);
            stockInfo.buyer_1_price = Double.valueOf(infos[11]);
            stockInfo.buyer_2_number = Long.valueOf(infos[12]);
            stockInfo.buyer_2_price = Double.valueOf(infos[13]);
            stockInfo.buyer_3_number = Long.valueOf(infos[14]);
            stockInfo.buyer_3_price = Double.valueOf(infos[15]);
            stockInfo.buyer_4_number = Long.valueOf(infos[16]);
            stockInfo.buyer_4_price = Double.valueOf(infos[17]);
            stockInfo.buyer_5_number = Long.valueOf(infos[18]);
            stockInfo.buyer_5_price = Double.valueOf(infos[19]);
            stockInfo.seller_1_number = Long.valueOf(infos[20]);
            stockInfo.seller_1_price = Double.valueOf(infos[21]);
            stockInfo.seller_2_number = Long.valueOf(infos[22]);
            stockInfo.seller_2_price = Double.valueOf(infos[23]);
            stockInfo.seller_3_number = Long.valueOf(infos[24]);
            stockInfo.seller_3_price = Double.valueOf(infos[25]);
            stockInfo.seller_4_number = Long.valueOf(infos[26]);
            stockInfo.seller_4_price = Double.valueOf(infos[27]);
            stockInfo.seller_5_number = Long.valueOf(infos[28]);
            stockInfo.seller_5_price = Double.valueOf(infos[29]);
            stockInfo.time = System.currentTimeMillis()/1000;
            return stockInfo;
        }catch(Exception e){
            System.out.println("异常信息：创建股票信息时发生异常\n"+e);
        }
        return null;
    }
    public void printStockInfo(){
        System.out.println(this.stock_name);
        System.out.println("买五     " + this.buyer_1_number + " : " + this.buyer_1_price);
        System.out.println("买四     " + this.buyer_2_number + " : " + this.buyer_2_price);
        System.out.println("买三     " + this.buyer_3_number + " : " + this.buyer_3_price);
        System.out.println("买二     " + this.buyer_4_number + " : " + this.buyer_4_price);
        System.out.println("买一     " + this.buyer_5_number + " : " + this.buyer_5_price);
        System.out.println("\n当前价格     " + this.current_price+"\n");        
        System.out.println("卖一     " + this.seller_1_number + " : " + this.seller_1_price);
        System.out.println("卖二     " + this.seller_2_number + " : " + this.seller_2_price);
        System.out.println("卖三     " + this.seller_3_number + " : " + this.seller_3_price);
        System.out.println("卖四     " + this.seller_4_number + " : " + this.seller_4_price);        
        System.out.println("卖五     " + this.seller_5_number + " : " + this.seller_5_price);
        System.out.println("时间     " + this.time);
        System.out.println("\n成交量：" + this.total_number);
        System.out.println("成交金额：" + this.total_price);
        
    }
    public static void main(String[] args){
        StockInfo a = StockInfo.getStockInfo("sh600652");
        if(a != null)
            a.printStockInfo();    
    }
}
