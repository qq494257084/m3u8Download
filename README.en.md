# m3u8Dowload
<h1>java download m3u8 video,decrypt & merge ts slice</h1>
<h2>
How to get a m3u8 link and code analysis please reference:
</h2>
https://blog.csdn.net/qq494257084/article/details/103551293
<h3>preparation</h3>
<pre>
JDK:1.8
IDE：IntelliJ IDEA
dependence：bcprov-jdk16-139.jar
Learn about the functions of the m3u8 tag
https://www.cnblogs.com/shakin/p/3870442.html
</pre>
<h3>example</h3>
<pre>
M3u8DownloadFactory.M3u8Download m3u8Download =  M3u8DownloadFactory.getInstance(M3U8URL);
//set the video directory
m3u8Download.setDir("F://m3u8JavaTest");
//set the video file name
m3u8Download.setFileName("test");
//set thread count 
m3u8Download.setThreadCount(100);
//set retry count
m3u8Download.setRetryCount(100);
//set connection timeout in millisecond
m3u8Download.setTimeoutMillisecond(10000L);
//add extra request headers to the request
  /*  Map<String, Object> headersMap = new HashMap<>();
    headersMap.put("Content-Type", "text/html;charset=utf-8");
    m3u8Download.addRequestHeaderMap(headersMap);*/
//set log level
//available：NONE INFO DEBUG ERROR
 m3u8Download.setLogLevel(Constant.DEBUG);
//set listener interval（ms）
m3u8Download.setInterval(500L);
//set http proxy if need
//m3u8Download.setProxy("172.50.60.3",8090);
//add listener to download
m3u8Download.addListener(new DownloadListener() {
    @Override
    public void start() {
        System.out.println("start download！");
    }
    @Override
    public void process(String downloadUrl, int finished, int sum, float percent) {
        System.out.println("download link：" + downloadUrl + "\t have finished" + finished + "\t total" + sum + "\t finished percentage" + percent + "%");
    }
    @Override
    public void speed(String speedPerSecond) {
        System.out.println("download speed："+speedPerSecond);
    }
    @Override
    public void end() {
        System.out.println("download is complete");
    }
});
//start download
m3u8Download.start();
</pre>

<h2>log</h2>

<h4>2021.12.20</h4>
* you can set http/socket proxy now

<h4>2020.05.22</h4>
* fix a bug that it can't correctly obtain a link

<h4>2020.04.01</h4>
* fix link conversion problems
* add a function that you can custom request headers

<h4>2020.02.10</h4>
* resolved an issue where files could not be merged when log level is NONE

<h4>2020.01.14</h4>
* add progress listener feature

<h4>2020.01.08</h4>
* memory optimization

<h4>2019.12.24</h4>
* solve base conversion problem

<h4>2019.12.23</h4>
* file path optimization 
* fixed the problem that the newly merged files would delete the previous video files

<h4>2019.12.21</h4>
* fix get an incorrect key
* update instructions
* memory optimization
* resolve link retrieval errors
* add IV vector offset decryption
* Resolved the problem that the program didn't exit after merging files

<h2>Tip</h2>
If you have any questions,you can email to ts_liyaling.qq.com.