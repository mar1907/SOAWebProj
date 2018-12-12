using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Services;
using MySql.Data;

[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
public class ClientService : System.Web.Services.WebService
{

    public ClientService()
    {

    }

    [WebMethod]
    public int LogIn(string name, string password)
    {
        using(var context = new deliveryEntities())
        {
            user query = context.users
                            .Where(u => u.username == name && u.password == password)
                            .FirstOrDefault<user>();

            if (query == null)
            {
                return -1;
            }
            else
            {
                return query.admin;
            }
        }
    }

    [WebMethod]
    public string Register(string name, string password)
    {
        using (var context = new deliveryEntities())
        {
            var us = new user()
            {
                username = name,
                password = password,
                admin = 0
            };

            context.users.Add(us);

            context.SaveChanges();

            return "Success";
        }
    }

    [WebMethod]
    public string GetPackages(int userId)
    {
        using (var context = new deliveryEntities())
        {
            var packs = context.packages
                            .Where(p => p.recv_id == userId || p.sender_id == userId);

            string result = "";

            foreach(package pack in packs)
            {
                result += pack.id + " " + pack.name + " " + pack.description + " " + pack.dest_city + "<br>";
            }

            return result;
        }
    }

    [WebMethod]
    public string SearchPackage(string name)
    {
        using (var context = new deliveryEntities())
        {
            var packs = context.packages
                            .Where(p => p.name == name);

            string result = "";

            foreach (package pack in packs)
            {
                result += pack.id + " " + pack.name + " " + pack.description + " " + pack.dest_city + "<br>";
            }

            return result;
        }

    }

    [WebMethod]
    public string GetTracking(int packId)
    {
        using (var context = new deliveryEntities())
        {
            var packTrackings = context.package_tracking
                                    .Where(p => p.package_id == packId);

            string result = "";

            foreach(package_tracking pack in packTrackings)
            {
                result += pack.city + " " + pack.moment + "<br>";
            }

            return result;
        }

    }

    [WebMethod]
    public int GetUserId(string name, string pass)
    {
        using (var context = new deliveryEntities())
        {
            user query = context.users
                            .Where(u => u.username == name && u.password == pass)
                            .FirstOrDefault<user>();

            if (query == null)
            {
                return -1;
            }
            else
            {
                return query.id;
            }
        }
    }

}
