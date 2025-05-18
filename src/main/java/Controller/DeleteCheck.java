package Controller;

import Repository.MoleCheckRepository;
import Service.MoleCheckService;
import Service.iRepository.iMoleCheckRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/delete-check")
public class DeleteCheck extends HttpServlet {
    private MoleCheckService moleCheckService;

    public void init() throws ServletException {
        iMoleCheckRepository moleCheckRepository = new MoleCheckRepository();
        moleCheckService = new MoleCheckService(moleCheckRepository);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("checkId"));
        moleCheckService.deleteMoleCheck(id);

        response.sendRedirect("main");
    }
}


