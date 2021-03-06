package com.nexusy.glp.parser.impl;

import com.nexusy.glp.data.basic.CMSInitialMarkData;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * @author lanhuidong
 * @since 2016-12-13
 */
public class CMSInitMarkPhaseTest extends GCLogLineParserTest {

    private CMSInitMarkParser parser = new CMSInitMarkParser();

    @Test
    public void testInitMarkJDK8() {
        String line = "2016-12-13T15:43:51.496+0800: 0.417: [GC (CMS Initial Mark) [1 CMS-initial-mark: 6790K(20480K)]"
                + " 7814K(29696K), 0.0000744 secs] [Times: user=0.01 sys=0.01, real=0.01 secs] ";
        CMSInitialMarkData data = parser.parse(line);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-13T15:43:51.496+0800", formatter);
        assertEquals(dateTime, data.getDateTime());
        assertEquals(417, data.getUptime());
        assertEquals("CMS Initial Mark", data.getPhase().toString());
        assertEquals(6790L * 1024, data.getOldGenUsage());
        assertEquals(20480L * 1024, data.getOldGenSize());
        assertEquals(7814L * 1024, data.getHeapUsage());
        assertEquals(29696L * 1024, data.getHeapSize());
        assertEquals(0.0000744, data.getStwDuration(), 0.00000001);
        assertEquals(0.01, data.getUserTime(), 0.001);
        assertEquals(0.01, data.getSysTime(), 0.001);
        assertEquals(0.01, data.getRealTime(), 0.001);
    }
}
