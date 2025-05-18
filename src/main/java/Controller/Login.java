package Controller;

import Service.AuthService;
import Repository.UserRepository;
import Service.iRepository.iUserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private AuthService authService;

    public void init() throws ServletException {
        iUserRepository userRepository = new UserRepository();
        authService = new AuthService(userRepository);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        int userId = authService.login(login, password);

        if (userId > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("id", userId);
            response.sendRedirect("main");
        } else {
            if (userId == -1) {
                response.sendRedirect("index.jsp?error=invalidLogin");
            } else if (userId == -2) {
                response.sendRedirect("index.jsp?error=invalidPassword");
            }
        }
    }
}