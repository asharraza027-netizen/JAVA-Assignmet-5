
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String type = request.getParameter("feedbackType");
        String comments = request.getParameter("comments");

        String dateTime = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a")
        );

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Feedback Submitted</title>");

        out.println("<style>");

        out.println("* { box-sizing: border-box; }");

        out.println("body {");
        out.println("margin: 0;");
        out.println("min-height: 100vh;");
        out.println("font-family: Arial, sans-serif;");
        out.println("background: linear-gradient(135deg, #dbeafe, #e9d5ff);");
        out.println("display: flex;");
        out.println("justify-content: center;");
        out.println("align-items: center;");
        out.println("padding: 25px;");
        out.println("}");

        out.println(".card {");
        out.println("background: white;");
        out.println("width: 100%;");
        out.println("max-width: 550px;");
        out.println("padding: 40px;");
        out.println("border-radius: 20px;");
        out.println("text-align: center;");
        out.println("box-shadow: 0 12px 35px rgba(0,0,0,0.12);");
        out.println("}");

        out.println(".success-icon {");
        out.println("width: 85px;");
        out.println("height: 85px;");
        out.println("border-radius: 50%;");
        out.println("background: #dcfce7;");
        out.println("color: #16a34a;");
        out.println("font-size: 48px;");
        out.println("display: flex;");
        out.println("align-items: center;");
        out.println("justify-content: center;");
        out.println("margin: 0 auto 20px;");
        out.println("}");

        out.println("h1 { color: #263568; margin-bottom: 10px; }");
        out.println(".subtitle { color: #777; margin-bottom: 28px; }");

        out.println(".details {");
        out.println("background: #f8faff;");
        out.println("padding: 20px;");
        out.println("border-radius: 12px;");
        out.println("text-align: left;");
        out.println("margin: 20px 0;");
        out.println("}");

        out.println(".details p {");
        out.println("color: #444;");
        out.println("margin: 12px 0;");
        out.println("overflow-wrap: anywhere;");
        out.println("}");

        out.println(".button {");
        out.println("display: inline-block;");
        out.println("background: #536dfe;");
        out.println("color: white;");
        out.println("padding: 14px 25px;");
        out.println("border-radius: 9px;");
        out.println("text-decoration: none;");
        out.println("font-weight: bold;");
        out.println("margin-top: 12px;");
        out.println("}");

        out.println(".button:hover { background: #3949ab; }");

        out.println(".footer {");
        out.println("color: #999;");
        out.println("font-size: 12px;");
        out.println("margin-top: 25px;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<div class='card'>");

        out.println("<div class='success-icon'>&#10003;</div>");

        out.println("<h1>Feedback Submitted!</h1>");

        out.println("<p class='subtitle'>Thank you, "
                + escapeHtml(name)
                + "! Your feedback means a lot to us.</p>");

        out.println("<div class='details'>");

        out.println("<p><b>Name:</b> " + escapeHtml(name) + "</p>");
        out.println("<p><b>Email:</b> " + escapeHtml(email) + "</p>");
        out.println("<p><b>Feedback Type:</b> " + escapeHtml(type) + "</p>");
        out.println("<p><b>Your Comments:</b> " + escapeHtml(comments) + "</p>");
        out.println("<p><b>Submitted On:</b> " + dateTime + "</p>");

        out.println("</div>");

        out.println("<a class='button' href='feedback.html'>");
        out.println("Submit Another Feedback");
        out.println("</a>");

        out.println("<div class='footer'>Student Feedback Portal</div>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    private String escapeHtml(String value) {
        if (value == null) return "";

        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }
}
