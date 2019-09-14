package complexity_measuring_tool.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import complexity_measuring_tool.dbaccess.FileAccess;
import complexity_measuring_tool.model.ViewFile;

/**
 * @author IT16173064 Peiris.M.R.P
 * Servlet implementation class OldHistoryController
 */
@WebServlet("/OldHistoryController")
public class OldHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldHistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
				ArrayList<ViewFile> viewFileList = FileAccess.retiveOldFileData();
				
				request.setAttribute("oldFileList", viewFileList);
				request.getRequestDispatcher("HistoryListView.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
				e.printStackTrace();
			}
	}

}
