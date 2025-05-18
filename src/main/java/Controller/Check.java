package Controller;

import Repository.MoleCheckRepository;
import Service.CheckService;

import Service.iRepository.iMoleCheckRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/check")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 5,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 15)
    public class Check extends HttpServlet {
    private CheckService checkService;

    public void init() throws ServletException {
        iMoleCheckRepository repository = new MoleCheckRepository();
        checkService = new CheckService(repository);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("check.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        int userId = (int) session.getAttribute("id");

        String location = request.getParameter("location");
        Part file = request.getPart("photo");

        String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
        String filePath = getServletContext().getRealPath("") + File.separator + "uploads" + File.separator + fileName;
        file.write(filePath);
        String imagePath = "uploads/" + fileName;

        checkService.makeCheck(userId, imagePath, location);

        response.sendRedirect("result-check");
    }
}
