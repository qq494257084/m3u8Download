package net.m3u8.listener;

public interface DownloadListener {
   //FIXME  Ref : https://github.com/Jay-Goo/M3U8Downloader/blob/master/library/src/main/java/jaygoo/library/m3u8downloader/OnTaskDownloadListener.java
    void start();

    void process(String downloadUrl, int finished, int sum, float percent);

    void speed(String speedPerSecond);

    void end();

}
