﻿//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Collections.Generic;

public partial class package
{
    public int id { get; set; }
    public string description { get; set; }
    public string dest_city { get; set; }
    public string name { get; set; }
    public string sender_city { get; set; }
    public int tracking { get; set; }
    public Nullable<int> recv_id { get; set; }
    public Nullable<int> sender_id { get; set; }
}

public partial class package_tracking
{
    public int id { get; set; }
    public string city { get; set; }
    public Nullable<System.DateTime> moment { get; set; }
    public Nullable<int> package_id { get; set; }
}

public partial class user
{
    public int id { get; set; }
    public int admin { get; set; }
    public string password { get; set; }
    public string username { get; set; }
}
