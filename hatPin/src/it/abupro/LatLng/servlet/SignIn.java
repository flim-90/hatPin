package it.abupro.LatLng.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.abupro.LatLng.function.*;
import it.abupro.LatLng.entities.*;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u1 = new User();
		UserHelper uH = new UserHelper();

		/*------------ controllo username ------------------*/
		String usr = request.getParameter("username");
		//vedi UserHelper.java / SignIn/ alredyExist()
		boolean usrAE  = uH.alredyExist("username", usr);
		//se username non � null e non � gi� in utilizzo lo assegna all'utente
		if (usr != null && usrAE == false) {
			u1.setUsername(usr);
			//se username � null segnala errore
		} else if (usr == null) {
			request.setAttribute("user_null", "Non hai inserito uno username!");
			//se username � gi� in uso segnala errore
		} else if (usrAE == true) {
			request.setAttribute("userAE", "Username gia' in uso, prova con un altro!");
		}
		/*---------------------------------------------------*/

		/*------------ controllo email ------------------ */
		String email = request.getParameter("email");
		//vedi UserHelper.java / SignIn/ alredyExist()
		boolean emailAE = uH.alredyExist("email", email);
		//se email non � null e non � gi� in utilizzo la assegna all'utente
		if (email != null && emailAE == false) {
			u1.setEmail(email);
			//se email � null segnala errore
		} else if (email == null) {
			request.setAttribute("email_null", "Non hai inserito un indirizzo email!");
			//se email � gi� in uso segnala errore
		} else if (emailAE == true) {
			request.setAttribute("email_AE", "Email gia' in uso, prova con un'altra!");
		}
		/*---------------------------------------------------*/

		/*------------ controllo password ------------------*/
		String psw1 = request.getParameter("password1");
		String psw2 = request.getParameter("password2");
		// vedi UserHelper.java / SignIn / checkPassword
		boolean checkedP = uH.checkPassword(psw1, psw2);
		//se le password sono diverse da null e coincidono assegna all'utente psw1
		if (psw1 != null && psw2 != null && checkedP == true) {
			u1.setPassword(psw1);
			//se psw1 o psw2 sono nulla segnala errore
		} else if (psw1 == null || psw2 == null){
			request.setAttribute("password_null", "Non hai inseito correttamente le password!");
			//se le password non coincidono segnala errore
		} else if (checkedP == false) {
			request.setAttribute("password_not_equals", "Le due password non coincidono<br>o non rispettano i prerequisiti!");
		}
		/*---------------------------------------------------*/
		
		/*-----------controllo data-------------------------*/
		String birthdate = request.getParameter("birthdate");
		DataHelper dH = new DataHelper();
		boolean check = dH.dataValida(birthdate);
		
		if (check == true) {
			u1.setBirthdate(birthdate);
		} else {
			request.setAttribute("birthdate_error", "Non hai inserito un formato di data valido!");
		}
		/*--------------------------------------------------*/

		/*------------ aggiunge tutti gli altri parametri ------------------*/
		u1.setName(request.getParameter("name"));
		u1.setSurname(request.getParameter("surname"));
		u1.setGender(request.getParameter("gender"));
		
		request.getRequestDispatcher("/registrazione.jsp").include(request, response);
		
		//salva utente su DB 
		//vedi UtenteHelper.java / SignIn / newUser()
		uH.newUser(u1);

		response.sendRedirect("index.html");
	}

}
