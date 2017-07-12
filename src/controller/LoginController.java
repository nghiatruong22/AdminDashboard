package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pojo.Staff;
import dao.StaffDAO;
import form.Login;

//@Controller
//@SessionAttributes
//public class LoginController {
//
//	@RequestMapping(value = "/addLogin", method = RequestMethod.POST)
//	public String addLogin(@ModelAttribute("login")
//							Login login, BindingResult result) {
//		
//		System.out.println("Username:" + login.getUserName() + 
//					"Password:" + login.getPassword());
//		
//		boolean found = false;
//        List<Staff> staffList = StaffDAO.getStaffList();
//        
//        for (int i = 0; i < staffList.size(); i++)
//        {
//        	Staff staff = staffList.get(i);
//        	System.out.println("UsernameS:" + staff.getName() + 
//					" - PasswordS:" + staff.getPassword());
//        	if (login.getUserName().equals(staff.getName()))
//        	{
//        		found = true;
//        		
//        		if (staff.getPassword().equals(login.getPassword()))
//        		{
//        			return "redirect:login.html";
//        		}
//        		else
//        		{
//        			return "redirect:hello.html";
//        		}
//        	}
//        }
//        
//        if (!found)
//        {
//        	return "redirect:hello.html";
//        }
//		
//		return "redirect:hello.html";
//	}
//	
//	@RequestMapping("/login")
//	public ModelAndView showLogin() {
//		
//		return new ModelAndView("login", "command", new Login());
//	}
//}

@Controller
@SessionAttributes
public class LoginController extends HttpServlet {
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		
		return new ModelAndView("login", "command", new Login());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
     String userId = request.getParameter("username");   
     String password = request.getParameter("password");
     //LoginService loginService = new LoginService();
     //boolean result = loginService.authenticateUser(userId, password);
     //User user = loginService.getUserByUserId(userId);
     
     
//     if(result == true){
//         request.getSession().setAttribute("user", user);      
//         response.sendRedirect("home.jsp");
//     }
//     else{
//         response.sendRedirect("error.jsp");
//     }
     
     
     System.out.println("Username:" + userId + 
				"Password:" + password);
//	
	boolean found = false;
	 List<Staff> staffList = StaffDAO.getStaffList();
	 
	 for (int i = 0; i < staffList.size(); i++)
	 {
	 	Staff staff = staffList.get(i);
	 	System.out.println("UsernameS:" + staff.getName() + 
					" - PasswordS:" + staff.getPassword());
	 	if (userId.equals(staff.getName()))
	 	{
	 		found = true;
	 		
	 		if (password.equals(staff.getPassword()))
	 		{
	 			response.sendRedirect("login.html");
	 		}
	 		else
	 		{
	 			response.sendRedirect("hello.html");
	 		}
	 	}
	 	
	 }
	 
	 if (!found)
		 response.sendRedirect("hello.html");
	 
    }
}
