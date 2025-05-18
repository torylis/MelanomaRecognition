package Controller;

import Repository.MoleCheckRepository;
import Repository.UserRepository;
import Service.Entity.UserEntity;
import Service.UserService;
import Service.iRepository.iMoleCheckRepository;
import Service.iRepository.iUserRepository;
import ViewModel.ResultCheckViewModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/result-check")
public class ResultCheck extends HttpServlet {
    private UserService userService;

    public void init() throws ServletException {
        iUserRepository userRepository = new UserRepository();
        iMoleCheckRepository moleCheckRepository = new MoleCheckRepository();
        userService = new UserService(userRepository, moleCheckRepository);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            response.sendRedirect("main");
            return;
        }
        int userId = (int) session.getAttribute("id");

        UserEntity user = userService.getUser(userId);

        ResultCheckViewModel viewModel = new ResultCheckViewModel(user.getChecks().getLast().getRisk());
        request.setAttribute("viewModel", viewModel);
        request.getRequestDispatcher("result-check.jsp").forward(request, response);
    }
}
