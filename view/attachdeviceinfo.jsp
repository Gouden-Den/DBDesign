<%@ page import="java.util.List" %>
<%@ page import="service.DeviceInfoService" %>
<%@ page import="entity.DeviceInfo" %>
<%@ page import="entity.AttachDeviceInfo" %>
<%@ page import="service.AttachDeviceInfoService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">
                <%
                    out.print(session.getAttribute("userId"));
                %>
            </a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->
        <div class="chs">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <li>
                        <a href="index.jsp"><i class="fa fa-dashboard fa-fw"></i> 首页</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw"></i> 部门<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="addDepartment.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 添加部门</a>
                            </li>
                            <li>
                                <a href="departmentTables.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 部门信息</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw"></i> 设备类别<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="addDeviceType.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 添加设备类别</a>
                            </li>
                            <li>
                                <a href="deviceTypeInfo.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 设备类别信息</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw"></i> 设备<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="addDevice.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 添加设备</a>
                            </li>
                            <li>
                                <a href="deviceInfo.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 设备基本信息</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw"></i> 附属设备<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="addAttachDevice.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 添加附属设备</a>
                            </li>
                            <li>
                                <a href="attachdeviceinfo.jsp.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 附属设备基本信息</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-wrench fa-fw"></i> 申请设备<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="requestUseInfo.jsp">待批准</a>
                            </li>
                            <li>
                                <a href="usingInfo.jsp">已批准</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">附属设备基本信息</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        附属设备基本信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>设备编号</th>
                                <th>附属类别</th>
                                <th>附属设备编号</th>
                                <th>附属设备名</th>
                                <th>附属设备数量</th>
                                <!--<th>购入日期</th>-->
                                <!--<th>安装日期</th>-->
                                <th>附属设备原值</th>
                                <!--<th>残值</th>-->
                                <!--<th>月折旧金额</th>-->
                                <!--<th>备注</th>-->
                                <th>操作</th>
                            </tr>
                            </thead>
                            <%
                                AttachDeviceInfoService attachDeviceInfoService=new AttachDeviceInfoService();
                                List<AttachDeviceInfo> results=attachDeviceInfoService.queryAttachDeviceInfo(request.getParameter("deviceId"));
                                out.print("<tbody>");
                                for (AttachDeviceInfo attachDeviceInfo : results){
                                    out.print("<tr class=\"odd gradeX\">\n" +
                                            "       <td><a href=\"/device?method=get&deviceId=" + attachDeviceInfo.getDeviceID() + "\">" + attachDeviceInfo.getDeviceID() + "</a></td>\n" +
                                            "       <td>" + attachDeviceInfo.getAttachType() + "</td>\n" +
                                            "       <td>" +attachDeviceInfo.getAttachDeviceID() + "</td>\n" +
                                            "       <td>" + attachDeviceInfo.getAttachNum() + "</td>\n" +
                                            "       <td>" + attachDeviceInfo.getAttachValue()+ "</td>\n" +
                                            "       <td><a href=\"/attachdevice?method=delete&attachDeviceId=" + attachDeviceInfo.getAttachDeviceID() +"&deviceId="+attachDeviceInfo.getDeviceID()+"\">删除</a>&nbsp;&nbsp;" +
                                            "        <a href=\"/attachdevice?method=updateTo&attachDeviceId=" + attachDeviceInfo.getAttachDeviceID() + "&deviceId="+ attachDeviceInfo.getAttachDeviceID()+"\">修改 </a></td>"+
                                            "   </tr>");
                                }
                                out.print("</tbody>");
                            %>
                        </table>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>

</body>

</html>