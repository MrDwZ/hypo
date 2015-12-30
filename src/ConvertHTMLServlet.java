import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by eiyasushiki on 15/12/22.
 */
public class ConvertHTMLServlet extends HttpServlet{
    String filePath;

    @Override
    public void init() throws ServletException {
        super.init();
        filePath = getServletContext().getInitParameter("");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = (File)req.getAttribute("HTMLFile");

        String outPath = "/usr/local/Cellar/tomcat/8.0.27/libexec/webapps/hypo/web/pages/" + file.getName()+ ".html";
        String execCmd = "pandoc -o " + outPath + " -5 " + file.getAbsolutePath();

        System.out.println(execCmd);
        Process p = Runtime.getRuntime().exec(new String[]{"zsh", "-c", execCmd});

        req.setAttribute("Convert", "Success");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
