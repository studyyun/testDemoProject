package com.example.test;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-24  17:16
 */
public class TestSigar {
    Sigar sigar = new Sigar();
    private static int[] diskList = null;

    public long[] getHostDiskFree() {

        long[] diskInfo = new long[2];

        try {
            FileSystem[] fslist = this.sigar.getFileSystemList();
            FileSystemUsage usage = null;
            long total = 0L;
            long free = 0L;
            if (diskList == null) {
                diskList = new int[fslist.length];
            }

            for(int i = 0; i < fslist.length; ++i) {
                if (diskList[i] != 1) {
                    FileSystem fs = fslist[i];

                    try {
                        usage = this.sigar.getFileSystemUsage(fs.getDirName());
                    } catch (Exception var11) {
                        System.out.println("获取文件服务器主机磁盘" + fs.getDirName() + "剩余量异常，" + fs.getDirName() + "盘为光驱");
//                        EmpExecutionContext.error("获取文件服务器主机磁盘" + fs.getDirName() + "剩余量异常，" + fs.getDirName() + "盘为光驱");
                        if (i <= diskList.length) {
                            diskList[i] = 1;
                        }
                        continue;
                    }

                    if (fs.getType() == 2) {
                        free += usage.getFree();
                        total += usage.getTotal();
                    }
                }
            }

            total /= 1024L;
            diskInfo[0] = total;
            free /= 1024L;
            diskInfo[1] = free;
            return diskInfo;
        } catch (SigarException var12) {
            System.out.println("获取文件服务器主机磁盘剩余量异常!");
//            EmpExecutionContext.error(var12, "获取文件服务器主机磁盘剩余量异常!");
            return diskInfo;
        }
    }
    
    public static void main(String[] args) {
        long[] hostDiskFree = new TestSigar().getHostDiskFree();
        for (long l : hostDiskFree) {
            System.out.println(l);
        }
        
        /*FileSystem[] fslist = new FileSystem[29];
        int[] diskList = new int[fslist.length];

        for (int i = 0; i <= fslist.length; i++) {
            System.out.println(diskList[i]);
        }*/
        
    }
    
}
