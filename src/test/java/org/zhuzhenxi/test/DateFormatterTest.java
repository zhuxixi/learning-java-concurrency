package org.zhuzhenxi.test;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatterTest {
    @Test
    public void testDateString(){
        long a = 1573200740424L;
        Date currentTime = new Date(1573200740424L);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals("2019-11-08 16:12:20",formatter.format(currentTime));
    }

}
