package Controller;

import Service.Entity.MoleCheckEntity;
import Repository.MoleCheckRepository;

import Service.MoleCheckService;
import Service.iRepository.iMoleCheckRepository;
import ViewModel.MoleCheckViewModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/check-info")
public class CheckInfo extends HttpServlet {
    private MoleCheckService moleCheckService;

    public void init() throws ServletException {
        iMoleCheckRepository moleCheckRepository = new MoleCheckRepository();
        moleCheckService = new MoleCheckService(moleCheckRepository);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("checkId"));

        MoleCheckEntity check = moleCheckService.getMoleCheck(id);

        MoleCheckViewModel viewModel = new MoleCheckViewModel(check.getMoleId(), check.getRisk(), check.getImagePath(), check.getDate(), check.getLocation());
        request.setAttribute("viewModel", viewModel);
        request.getRequestDispatcher("check-info.jsp").forward(request, response);
    }
}

