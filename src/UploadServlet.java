import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class UploadServlet extends HttpServlet {

    private String filePath;
    private int maxFileSize = 500 * 1024;
    private int maxMemSize = 400 * 1024;
    private File file ;

    public void init( ){
        // 获取文件将被存储的位置
        filePath = getServletContext().getInitParameter("file-upload");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        //super.doPost(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        System.out.println("test");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);
        factory.setRepository(new File(filePath));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        upload.setSizeMax( maxFileSize );

        try{
            List fileItems = upload.parseRequest(request);

            Iterator i = fileItems.iterator();
            while (i.hasNext ()) {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () ) {
                    String fileName = fi.getName();

                    if( fileName.lastIndexOf("/") >= 0 ) {
                        file = new File( filePath + fileName.substring( fileName.lastIndexOf("/"))) ;
                    } else {
                        file = new File( filePath + fileName.substring(fileName.lastIndexOf("/")+1)) ;
                    }

                    System.out.println(file.getPath());
                    if (!file.exists()) file.createNewFile();
                    fi.write(file);
                    request.setAttribute("HTMLFile", file);
                    request.getRequestDispatcher("ConvertHTML").forward(request, response);
                }
            }
        }catch(Exception ex) {}
    }
}