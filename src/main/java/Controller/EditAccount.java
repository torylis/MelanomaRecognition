package Controller;

import Repository.MoleCheckRepository;
import Repository.UserRepository;
import Service.Entity.UserEntity;
import Service.UserService;
import Service.iRepository.iMoleCheckRepository;
import Service.iRepository.iUserRepository;
import ViewModel.EditAccountViewModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/edit-account")
public class EditAccount extends HttpServlet {
    private UserService userService;

    public void init() throws ServletException {
        iUserRepository userRepository = new UserRepository();
        iMoleCheckRepository moleCheckRepository = new MoleCheckRepository();
        userService = new UserService(userRepository, moleCheckRepository);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("id");
        UserEntity user = userService.getUser(userId);

        EditAccountViewModel viewModel = new EditAccountViewModel(user.getUsername(), user.getGender(), user.getBirthdate());
        request.setAttribute("viewModel", viewModel);
        request.getRequestDispatcher("/edit-account.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        int userId = (int) session.getAttribute("id");

        UserEntity user = userService.getUser(userId);
        user.setUsername(username);
        user.setGender(gender);
        user.setBirthdate(birthdate);
        userService.updateUser(user);

        response.sendRedirect("account");
    }
}

