package Controller;

import Repository.MoleCheckRepository;
import Repository.UserRepository;
import Service.Entity.UserEntity;
import Service.UserService;
import Service.iRepository.iMoleCheckRepository;
import Service.iRepository.iUserRepository;
import ViewModel.AccountViewModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet ("/account")
public class Account extends HttpServlet {
    private UserService userService;

    public void init() throws ServletException {
        iUserRepository userRepository = new UserRepository();
        iMoleCheckRepository moleCheckRepository = new MoleCheckRepository();
        userService = new UserService(userRepository, moleCheckRepository);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        int userId = (int) session.getAttribute("id");

        UserEntity user = userService.getUser(userId);
        AccountViewModel viewModel = new AccountViewModel(user.getUsername(), user.getGender(), user.getBirthdate());
        request.setAttribute("viewModel", viewModel);
        request.getRequestDispatcher("account.jsp").forward(request, response);
    }
}
