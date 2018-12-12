package com.ds.html;

import com.ds.entity.User;
import com.ds.entity.dto.PackageDTO;

public class HtmlUtils {

    public static String getUsersTable(User[] users) {
        String table = "<table style=\"width:100%\" border=\"1\">\n" +
                "  <tr>\n" +
                "    <th>Id</th>\n" +
                "    <th>Username</th> \n" +
                "    <th>Admin</th>\n" +
                "  </tr>";
        for(User user: users){
            table += "<tr>";
            table += "<td>" + user.getId() + "</td>";
            table += "<td>" + user.getUsername() + "</td>";
            table += "<td>" + (user.getAdmin() == 1 ? "Yes" : "No") + "</td>";
            table += "</tr>";
        }
        return table;
    }

    public static String getPackageTable(PackageDTO[] packages) {
        String table = "<table style=\"width:100%\" border=\"1\">\n" +
                "  <tr>\n" +
                "    <th>Id</th>\n" +
                "    <th>Name</th> \n" +
                "    <th>Description</th>\n" +
                "    <th>Sender City</th>\n" +
                "    <th>Destination City</th>\n" +
                "    <th>Sender id</th>\n" +
                "    <th>Destination id</th>\n" +
                "    <th>Tracked</th>\n" +
                "  </tr>";
        for(PackageDTO pack: packages){
            table += "<tr>";
            table += "<td>" + pack.getId() + "</td>";
            table += "<td>" + pack.getName() + "</td>";
            table += "<td>" + pack.getDescription() + "</td>";
            table += "<td>" + pack.getSenderCity() + "</td>";
            table += "<td>" + pack.getDestCity() + "</td>";
            table += "<td>" + pack.getSenderId() + "</td>";
            table += "<td>" + pack.getReceiverId() + "</td>";
            table += "<td>" + (pack.getTracking() == 1 ? "Yes" : "No") + "</td>";
            table += "</tr>";
        }
        return table;
    }

}
