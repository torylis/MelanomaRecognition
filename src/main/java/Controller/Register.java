package Controller;

import Service.AuthService;
import Repository.UserRepository;
import Service.iRepository.iUserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/register")
public class Register extends HttpServlet {
    private AuthService authService;

    public void init() {
        iUserRepository userRepository = new UserRepository();
        authService = new AuthService(userRepository);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));

        int userId = authService.register(login, password, username, gender, birthdate);

        if (userId != -1) {
            HttpSession session = request.getSession();
            session.setAttribute("id", userId);
            response.sendRedirect("main");
        } else {
            response.sendRedirect("register.jsp?error=loginExists");
        }
    }
}

