package edu.findvideo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.File;

public class DownloadFile extends HttpServlet
{
  /**
     * Constructor of the object.
     */
    public DownloadFile() {
        super();
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path=request.getParameter("path");
        path = new String(path.getBytes("iso-8859-1"),"UTF-8");
        String filename = new String("video.mp4");
        SmartUpload mySmartUpload = new SmartUpload();
        try {
            //初始化
            mySmartUpload.initialize(this.getServletConfig(), request, response);
            //设置不自动打开
            mySmartUpload.setContentDisposition(null);
            mySmartUpload.downloadFile(path+filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        //String name=request.getParameter("name");
//        String path=request.getParameter("url");		//获取上传文件的路径
//        //name = new String(name.getBytes("iso-8859-1"),"UTF-8");
//        path = new String(path.getBytes("iso-8859-1"),"UTF-8");
//        File file = new File(path);						//根据该路径创建文件对象
//        InputStream in = new FileInputStream(file);		//创建文件字节输入流
//        OutputStream os = response.getOutputStream();	//创建输出流对象
//        response.addHeader("Content-Disposition", "attachment;filename="
//                + new String(file.getName().getBytes("UTF-8"),"iso-8859-1"));	//设置应答头信息
//        response.addHeader("Content-Length", file.length() + "");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/octet-stream");
//        int data = 0;
//        while ((data = in.read()) != -1) {					//循环读取文件
//            os.write(data);								//向指定目录中写文件
//        }
//        os.close();										//关闭流
//        in.close();

    }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.DownloadFile
 * JD-Core Version:    0.6.1
 */