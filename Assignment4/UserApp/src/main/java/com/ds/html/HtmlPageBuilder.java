package com.ds.html;

import com.ds.entity.Package;
import com.ds.entity.PackageTracking;
import com.ds.entity.User;
import com.ds.entity.dto.PackageDTO;
import com.ds.entity.dto.PackageTrackingDTO;

import javax.servlet.http.HttpServletRequest;

public class HtmlPageBuilder {

    public static String getRegisterHtml(HttpServletRequest request){
        String message = (String) request.getSession().getAttribute("message");

        String page = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n" +
                "<html>\n" +
                "   <body>\n" +
                "      <form action = \"/register\" method = \"POST\">\n" +
                "         Username: <input type = \"text\" name = \"username\">\n" +
                "         <br />\n" +
                "         Password: <input type = \"password\" name = \"password\" />\n" +
                "         <br>" +
                "         <input type = \"submit\" value = \"Submit\" />\n" +
                (message == null ? "" : message) +
                "      </form>\n" +
                "   </body>\n" +
                "</html>";

        return page;
    }

    public static String getLoginHtml(String message){

        String page = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n" +
                "<html>\n" +
                "   <body>\n" +
                "      <form action = \"/\" method = \"POST\">\n" +
                "         Username: <input type = \"text\" name = \"username\">\n" +
                "         <br />\n" +
                "         Password: <input type = \"password\" name = \"password\" />\n" +
                "         <br>" +
                "         <input type = \"submit\" value = \"Submit\" />\n" +
                "      </form>\n" +
                (message == null ? "" : message) +
                "<a href=\"/register\">No account? Register</a>"+
                "   </body>\n" +
                "</html>";

        return page;
    }

    public static String getAdminHtml(HttpServletRequest request, User[] users, PackageDTO[] packs){
        String message = (String) request.getSession().getAttribute("message");

        String page = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n" +
                "<html>\n" +
                "   <body>\n" +
                HtmlUtils.getUsersTable(users)+
                HtmlUtils.getPackageTable(packs)+
                "<form action=\"/admin\" method=\"POST\">\n" +
                "        Pack Id: <input type=\"text\" name=\"id\">\n" +
                "        <br>\n" +
                "        Sender id: <input type=\"text\" name=\"senderId\">\n" +
                "        <br>\n" +
                "        Receiver id: <input type=\"text\" name=\"receiverId\">\n" +
                "        <br>\n" +
                "        Name: <input type=\"text\" name=\"name\">\n" +
                "        <br>\n" +
                "        Description: <input type=\"text\" name=\"description\">\n" +
                "        <br>\n" +
                "        Sender city: <input type=\"text\" name=\"senderCity\">\n" +
                "        <br>\n" +
                "        Destination city: <input type=\"text\" name=\"destinationCity\">\n" +
                "        <br>\n" +
                "        Route:" +
                "        <br>" +
                "        City: <input type=\"text\" name=\"city\">\n" +
                "        <br>" +
                "        Time: <input type=\"datetime-local\" name=\"time\">\n" +
                "        <br>\n" +
                "        <br>\n" +
                "<input type=\"submit\" name=\"action\" value=\"Add\">\n" +
                "        <br>\n" +
                "<input type=\"submit\" name=\"action\" value=\"Delete\">\n" +
                "        <br>\n" +
                "<input type=\"submit\" name=\"action\" value=\"Register package\">" +
                "        <br>\n" +
                "<input type=\"submit\" name=\"action\" value=\"Update status\">" +
                "    </form>" +
                (message == null ? "" : message) +
                "   </body>\n" +
                "</html>";

        return page;
    }

    public static String getUserHtml(HttpServletRequest request, String packages, String pack, String trackings){
        String message = (String) request.getSession().getAttribute("message");

        String page = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n" +
                "<html>\n" +
                "   <body>\n" +
                "<br>Packages:<br>" +
                packages +
                "<form action=\"/user\" method=\"POST\">\n" +
                "        Pack Id: <input type=\"text\" name=\"id\">\n" +
                "        <br>\n" +
                "        Pack name: <input type=\"text\" name=\"name\">\n" +
                "        <br>\n" +
                "<input type=\"submit\" name=\"action\" value=\"Search by name\">\n" +
                "        <br>\n" +
                "<input type=\"submit\" name=\"action\" value=\"Check status\">\n" +
                "    </form>" +
                (message == null ? "" : message) +
                "<br>Found:<br>" +
                pack +
                "<br>Tracking:<br>" +
                trackings +
                "   </body>\n" +
                "</html>";

        return page;
    }

}
